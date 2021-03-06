package com.andreabazerla.facade;

import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.andreabazerla.bean.BeanFactory;
import com.andreabazerla.bean.BeanProduct;
import com.andreabazerla.bean.BeanPurchase;
import com.andreabazerla.bean.BeanReceipt;
import com.andreabazerla.bean.BeanSearch;
import com.andreabazerla.bean.PageBeanFactory;
import com.andreabazerla.bean.PageBeanHome;
import com.andreabazerla.bean.PageBeanProductDetails;
import com.andreabazerla.bean.PageBeanShopping;
import com.andreabazerla.model.Factory_t;
import com.andreabazerla.model.Product_t;
import com.andreabazerla.model.Purchase_t;
import com.andreabazerla.model.Receipt_t;
import com.andreabazerla.model.User_t;
import com.andreabazerla.service.FactoryService;
import com.andreabazerla.service.ProductService;
import com.andreabazerla.service.PurchaseService;
import com.andreabazerla.service.ReceiptService;
import com.andreabazerla.service.UserService;

@Component
@Transactional
public class WebFacadeImpl implements WebFacade
{
	
	@Autowired
	private ProductService productService;

	@Autowired
	private FactoryService factoryService;

	@Autowired
	private UserService userService;

	@Autowired
	private PurchaseService purchaseService;

	@Autowired
	private ReceiptService receiptService;

	@Override
	public void addToCart(int idUser,
	                      int idProduct)
	{
		Product_t product = productService.get(idProduct);
		User_t user = userService.get(idUser);

		List<Product_t> productList = user.getProductCartList();

		productList.add(product);

	}

	@Override
	public List<BeanProduct> getBeanProductListFromCart(int idUser)
	{

		List<BeanProduct> beanProductPreviewList = new ArrayList<>();

		User_t user = userService.get(idUser);

		for (Product_t product : user.getProductCartList())
		{
			BeanProduct beanProduct = new BeanProduct();

			beanProduct.setId(product.getId());
			beanProduct.setName(product.getName());
			beanProduct.setDescription(product.getDescription());
			beanProduct.setPrice(product.getPrice());

			beanProductPreviewList.add(beanProduct);
		}

		return beanProductPreviewList;

	}

	@Override
	public Map<BeanReceipt, BeanPurchase> getBeanReceiptPurchaseMap(int idUser)
	{

		Map<BeanReceipt, BeanPurchase> beanReceiptPurchaseMap = new HashMap<>();

		User_t user = userService.get(idUser);

		for (Entry<Receipt_t, Purchase_t> receiptPurchaseEntry : user.getReceiptPurchaseMap()
		                                                             .entrySet())
		{

			List<Product_t> productList = receiptPurchaseEntry.getValue()
			                                                  .getProductList();

			BeanPurchase beanPurchase = new BeanPurchase();
			for (Product_t product : productList)
			{
				BeanProduct beanProductPreview = new BeanProduct();

				beanProductPreview.setId(product.getId());
				beanProductPreview.setName(product.getName());
				beanProductPreview.setDescription(product.getDescription());
				beanProductPreview.setPrice(product.getPrice());

				beanPurchase.add(beanProductPreview);
			}

			BeanReceipt beanReceipt = new BeanReceipt();
			beanReceipt.setId(receiptPurchaseEntry.getValue()
			                                      .getReceipt()
			                                      .getId());
			beanReceipt.setFlag(receiptPurchaseEntry.getValue()
			                                        .getReceipt()
			                                        .getFlag());

			beanPurchase.setBeanReceipt(beanReceipt);

			beanReceiptPurchaseMap.put(beanReceipt,
			                           beanPurchase);
		}

		return beanReceiptPurchaseMap;
	}

	@Override
	public PageBeanShopping setPageBeanShopping(List<BeanProduct> beanProductPreviewList,
	                                            int idUser,
	                                            PageBeanShopping pageBeanShopping)
	        throws SQLException
	{

		User_t user = getUserService().get(idUser);

		Map<Receipt_t, Purchase_t> receiptPurchaseMap = user.getReceiptPurchaseMap();
		Map<BeanReceipt, BeanPurchase> beanReceiptPurchaseMap = new HashMap<>();

		Receipt_t receipt = new Receipt_t();
		BeanReceipt beanReceipt = new BeanReceipt();

		float amount = 0;

		Purchase_t purchase = new Purchase_t();
		BeanPurchase beanPurchase = new BeanPurchase();

		for (BeanProduct beanProductPreview : beanProductPreviewList)
		{
			Product_t product = getProductService().get(beanProductPreview.getId());
			product.setPurchase(purchase);

			purchase.add(product);
			beanPurchase.add(beanProductPreview);

			purchaseService.create(purchase);

			amount += product.getPrice();

		}

		Date date = new Date();
		Random random = new Random();
		int code = random.nextInt(1000000000);

		receipt.setAmount(amount);
		receipt.setCode(code);
		receipt.setDate(date);
		receipt.setFlag(0);

		purchase.setReceipt(receipt);

		receiptPurchaseMap.put(receipt,
		                       purchase);

		user.setProductCartList(null);

		beanReceipt.setId(receipt.getId());
		beanReceipt.setFlag(receipt.getFlag());

		beanPurchase.setBeanReceipt(beanReceipt);

		beanReceiptPurchaseMap.put(beanReceipt,
		                           beanPurchase);

		pageBeanShopping.set(beanReceiptPurchaseMap);

		return pageBeanShopping;

	}

	@Override
	public ProductService getProductService()
	{
		return productService;
	}

	@Override
	public FactoryService getFactoryService()
	{
		return factoryService;
	}

	@Override
	public UserService getUserService()
	{
		return userService;
	}

	@Override
	public PurchaseService getPurchaseService()
	{
		return purchaseService;
	}

	@Override
	public ReceiptService getReceiptService()
	{
		return receiptService;
	}

	@Override
	public void createNewProduct(int idUser,
	                             HttpServletRequest request)
	        throws SQLException
	{

		String name = request.getParameter("name");
		String description = request.getParameter("description");
		float price = Integer.parseInt(request.getParameter("price"));
		String type = request.getParameter("type");
		String console = request.getParameter("console");
		String dateString = request.getParameter("date");

		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");

		Date date = null;
		try
		{
			date = formatter.parse(dateString);
		}
		catch (ParseException e)
		{
			e.printStackTrace();
		}

		char gadge = request.getParameter("gadge")
		                    .charAt(0);
		int model = Integer.parseInt(request.getParameter("model"));
		Factory_t factory = getFactoryService().get(Integer.parseInt(request.getParameter("factory")));
		getFactoryService().create(factory);
		int build = Integer.parseInt(request.getParameter("year"));
		String genre = request.getParameter("genre");

		Product_t product = new Product_t(factory,
		                                  null,
		                                  name,
		                                  description,
		                                  price,
		                                  type,
		                                  console,
		                                  date,
		                                  gadge,
		                                  model,
		                                  build,
		                                  genre);

		getProductService().create(product);

	}

	@Override
	public PageBeanProductDetails getProductBean(int productId,
	                                             PageBeanProductDetails beanProductDetails)
	{

		Product_t product = getProductService().get(productId);

		beanProductDetails.setId(product.getId());
		beanProductDetails.setFactory(getFactoryService().get(product.getFactory()
		                                                             .getId()));

		beanProductDetails.setName(product.getName());
		beanProductDetails.setDescription(product.getDescription());
		beanProductDetails.setPrice(product.getPrice());
		beanProductDetails.setType(product.getType());
		beanProductDetails.setConsole(product.getConsole());
		beanProductDetails.setDate(product.getDate());
		beanProductDetails.setGadge(product.getGadge());
		beanProductDetails.setModel(product.getModel());
		beanProductDetails.setBuild(product.getBuild());
		beanProductDetails.setGenre(product.getGenre());

		return beanProductDetails;

	}

	@Override
	public void deletePurchase(int idUser,
	                           int idReceipt)
	{

		Receipt_t receipt_t = getReceiptService().get(idReceipt);
		User_t user_t = getUserService().get(idUser);

		Purchase_t purchase_t = user_t.getReceiptPurchaseMap()
		                              .get(receipt_t);

		if (purchase_t != null)
		{
			user_t.getReceiptPurchaseMap()
			      .remove(receipt_t);
		}
	}

	@Override
	public PageBeanFactory getPageBeanFactory(int id)
	{
		PageBeanFactory pageBeanFactory = new PageBeanFactory();

		Factory_t factory = (Factory_t) factoryService.get(id);

		BeanFactory beanFactory = new BeanFactory();
		beanFactory.setId(factory.getId());
		beanFactory.setName(factory.getName());

		for (Product_t product : factory.getProductList())
		{
			BeanProduct beanProduct = new BeanProduct();

			beanProduct.setId(product.getId());
			beanProduct.setName(product.getName());
			beanProduct.setDescription(product.getDescription());
			beanProduct.setPrice(product.getPrice());

			beanFactory.add(beanProduct);
		}

		pageBeanFactory.setBeanFactory(beanFactory);

		return pageBeanFactory;
	}

	@Override
	public PageBeanHome getPageBeanHome(BeanSearch beanSearch)
	{

		List<BeanProduct> beanProductList = this.getProductService()
		                                        .read(beanSearch);

		PageBeanHome pageBeanHome = new PageBeanHome();

		for (BeanProduct beanProduct : beanProductList)
		{
			pageBeanHome.add(beanProduct);
		}

		List<BeanFactory> beanFactoryList = getFactoryService().getAllFactory();

		for (BeanFactory beanFactory : beanFactoryList)
		{
			beanSearch.add(beanFactory);
		}

		pageBeanHome.setBeanSearch(beanSearch);

		return pageBeanHome;

	}

}
