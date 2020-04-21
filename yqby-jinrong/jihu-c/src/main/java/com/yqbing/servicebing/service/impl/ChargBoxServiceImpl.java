package com.yqbing.servicebing.service.impl;

import java.math.BigDecimal;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import net.sf.json.JsonConfig;

import org.apache.commons.lang.StringUtils;
import org.apache.poi.ss.formula.functions.T;
import org.docx4j.model.datastorage.XPathEnhancerParser.main_return;
import org.json.JSONArray;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.alibaba.druid.support.logging.Log;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.domain.AlipayTradeAppPayModel;
import com.alipay.api.internal.util.AlipaySignature;
import com.alipay.api.request.AlipayTradeAppPayRequest;
import com.alipay.api.request.AlipayTradeCreateRequest;
import com.alipay.api.response.AlipayTradeAppPayResponse;
import com.alipay.api.response.AlipayTradeCreateResponse;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.yqbing.servicebing.common.ErrorCodeEnum;
import com.yqbing.servicebing.repository.database.abstracts.StoreHouseAbs;
import com.yqbing.servicebing.repository.database.bean.AppAppraise;
import com.yqbing.servicebing.repository.database.bean.AppRecommend;
import com.yqbing.servicebing.repository.database.bean.AppWealthRule;
import com.yqbing.servicebing.repository.database.bean.ChargOrder;
import com.yqbing.servicebing.repository.database.bean.FreeScale;
import com.yqbing.servicebing.repository.database.bean.StoreHouse;
import com.yqbing.servicebing.repository.database.bean.UserAppTask;
import com.yqbing.servicebing.repository.database.bean.UserInfoBean;
import com.yqbing.servicebing.repository.database.bean.UserTaskLog;
import com.yqbing.servicebing.repository.database.dao.AppRecommendMapper;
import com.yqbing.servicebing.repository.database.dao.AppWealthRuleExample;
import com.yqbing.servicebing.repository.database.dao.AppWealthRuleMapper;
import com.yqbing.servicebing.repository.database.dao.ChargOrderExample;
import com.yqbing.servicebing.repository.database.dao.ChargOrderMapper;
import com.yqbing.servicebing.repository.database.dao.FreeScaleMapper;
import com.yqbing.servicebing.repository.database.dao.StoreHouseMapper;
import com.yqbing.servicebing.repository.database.dao.UserAppTaskMapper;
import com.yqbing.servicebing.repository.database.dao.UserInfoBeanMapper;
import com.yqbing.servicebing.repository.database.dao.UserLocalAppMapper;
import com.yqbing.servicebing.repository.database.dao.UserTaskLogExample;
import com.yqbing.servicebing.repository.database.dao.UserTaskLogExample.Criteria;
import com.yqbing.servicebing.repository.database.dao.UserTaskLogMapper;
import com.yqbing.servicebing.repository.redis.RCharBoxData;
import com.yqbing.servicebing.repository.redis.RStoreHouseData;
import com.yqbing.servicebing.repository.redis.RStoreInfoData;
import com.yqbing.servicebing.repository.redis.RUserAppTaskData;
import com.yqbing.servicebing.repository.redis.RUserLogBean;
import com.yqbing.servicebing.repository.redis.StoreInfoBean;
import com.yqbing.servicebing.service.AccountService;
import com.yqbing.servicebing.service.ChargBoxService;
import com.yqbing.servicebing.service.CommonService;
import com.yqbing.servicebing.service.StoreInfoService;
import com.yqbing.servicebing.utils.DataFormatUntil;
import com.yqbing.servicebing.utils.DataUtils;
import com.yqbing.servicebing.utils.DateUtil;
import com.yqbing.servicebing.utils.HttpRequest;
import com.yqbing.servicebing.utils.HttpServiceUtil;
import com.yqbing.servicebing.utils.NotifyUtil;
import com.yqbing.servicebing.utils.SendUtils;
import com.yqbing.servicebing.webapp.alipay.AlipayConfig;
import com.yqbing.servicebing.webapp.alipay.AlipayCore;
import com.yqbing.servicebing.webapp.response.BoxOrder;
import com.yqbing.servicebing.webapp.response.BoxStoreAppRes;
import com.yqbing.servicebing.webapp.response.ChargCode;
import com.yqbing.servicebing.webapp.response.ChargHomeRes;
import com.yqbing.servicebing.webapp.response.ChargPass;
import com.yqbing.servicebing.webapp.response.CpdApps;
import com.yqbing.servicebing.webapp.response.EntryVo;
import com.yqbing.servicebing.webapp.response.PartyApps;
import com.yqbing.servicebing.webapp.response.ScreenRes;
import com.yqbing.servicebing.webapp.response.StoreAppRes;
import com.yqbing.servicebing.webapp.response.ThirdPartyAppsRes;


@Service("chargBoxService")
@SuppressWarnings("all")
public class ChargBoxServiceImpl extends CommonService implements ChargBoxService{
	
	private static String private_key = "MIIEvgIBADANBgkqhkiG9w0BAQEFAASCBKgwggSkAgEAAoIBAQCUo3t5CpkRW1uBCp/J1OyT5ZiZICzV4wOLZ5ufMFHLv0h4yybkgABZK1ZG9DvaA9RM+MD2H37hy95LVqONmXrUBli54KzAsOUKKMIH5HjetW8TyrlzoxzLKhcz/OZ0rnBakbOm3yIZBkbm9WQIfIhP1pTh0KrKoBXM2FvooFBUHCXumBtnsQ+PQrTc6/HOxuHX28JlRe3bToz13jhbUi0BvmPNc/Lm64o26CJZwR/x8x0LE4JEU7R+9R6NL43ovjJD3avvuwPaeQmyjz5m8kh3tQdfxa7q0tkaRoAbt3jdnG8EqbMiv5pXgyTphK/yNwIpZa32BYXpnYmpwJhdFEupAgMBAAECggEAEmsjrL8UcqModpgTbtY0rqr/utHS3HoyAT9IeHRrXl0IpPc/jYcTA/mrykUPeZeJ4jPc7WK/vUke9aT5xV0kbEuRCQ9/OK1y5Exipsm39Jj097XiPyMSOVaw419OS10mTQLLCT2TIxi1Bn+X8rlDxujnMAhEcbFeojCZSv06lwFo8MwCefzt38FjtAf2zRQKQvIKL66/MmXDLdT/dnHSHXKDzxjLPNuYaz7RV2hKW3rUJS81kD827rAD1UwVpq/VJPhQ0FJ1F0i67le2JbS32GkyN1HitxAEoh2ZPkMzwHagRAs8JKk/mHOJc217qLqFz++atyj5HJhp5rek4aB9AQKBgQDln099Bipkf/FVOtyQdjv04UlB6XRAqX3lMuTMKAvDCLOLhZVD9LyfWtlnWZyLCUjbrMmeRGsL8aLAACR5im/R/6mw5w5BkFD4e1Ys5eC5p0hpNozre5M79+PVxun1JJI2DJwOzugM9MP/6lRFzudxU5a23kqu+aHGeEuoEWzUoQKBgQCltp5KRvBu1DQbBnjUqAyZ9ogAIUFFwyt8rqLh1LpexgyqROM+YzsTn8cXW0GvXTNUgKNEUfiCSTOmOZKJU6LVAMq7Pgj7m2XAWzvTtJz/yg4nje9oZayBK0SEkiIHH0H+4dBKtdXXiax0T3MFObfT1s3XY0TvKS53uPU4IN2SCQKBgA5I29wOPyLjZrMDp2cBQ/eW8ES+bjH7mU5h3SPqNdkbOHgshj2lAvry3uV0CK4JlNO9qwlCflpO3O4O1DYPa6dnvTm5FgT0ImVi3tiKMHG8O1/4OcoIdP9dC3poFnPeo43jOO4e5wavT2YjQLzbA0Dkj1Ku/3xlITBEmYhKFTghAoGBAIy2CajmnchuFiSQlU91tuWRaiA6HLPBKw7/Nz3tpadOInj+b7uNBR//v0185sSirjBl3rznoc33nIzcPCqxwwV9W6gs3/HOHVN95Mo6hknI58X8hrquAxHXjKHJeG11xFNKqdSWnJMdyzskL3XTcd3GexkWqPUvkc6FVmwntB0JAoGBAIK70iccM6M/XhRh0oeJgKikUu3eOzvd1hTuS/I97k4v2v/lG74/4GTUyFY35TP7u8D1ttSmUG9u30BpLTX43N99fdw7Jb2zuN5pIvcAOigdUEBGbMA1JGzaeqoq81DowyMCxBJ7PoE6BuTa+5/YVPOqHSk5PFJDIjD0BFdELOzn";   
	private	static String alipay_public_key = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAmM1D/TEBcCYEwi2L1ETkdq3eBTKg1mrbmbanJCCJ5Zfv4cDuMzd4MxeBcuic8TlI7Hbu082E5yTvo8GJKBRdVoxRUmc/Pau7nzDspEwSk1O1wVn/FKp9BE0YpG1oRwP1sBw8aMIG/mH7llwWN5vg92Nrap2x4BauCJm81relVY5ePn59a2+dMWq7JGB0+Ody9z3jwKkkWQbPT/aG5ZyagxERV1SFu68tz8PVbLeftsOJB2KxzZvIsS7LRI1CPnGSS+txzWcwodyMrnZvF8QeMuqqrd2ZXbt0OosIASA5Zt9nwUoXMKbkdI274TR92t0uqyqPMt6YrFjIZ2t1zmkDWwIDAQAB";
	
	 private static final Logger LOGGER = LoggerFactory.getLogger(ChargBoxServiceImpl.class);
	 private static final byte s = 0;
	 private static final byte t = 1;
	 private static final byte y = 2;
	 
	 @Value("${charg_service}")
	 private   String  chargHttps;
	 @Value("${ali_https}")
	 private   String  aliHttps;
	 @Value("${ali_appid}")
	 private   String  aliAppid;
	 @Value("${private_key}")
	 private   String  privateKey;
	 @Value("${alipay_public_key}")
	 private   String  alipayBublicKey;
	 @Value("${ali_gateway}")
	 private   String  aliGateway;
//	 private static  String  chargHttps = "http://39cd8365.ngrok.io";
	 @Resource
	 private AppRecommendMapper appRecommendMapper= null;
	 @Resource
	 private AccountService accountService = null;
	 
	 @Resource
	 private UserInfoBeanMapper userInfoBeanMapper = null;
	 @Resource
	 private StoreHouseMapper storeHouseMapper = null;
	 
	 @Resource
	 private RUserLogBean rUserLogBean = null;
	 @Resource
	 private RCharBoxData rCharBoxData = null;
	 @Resource
	 private RUserAppTaskData rUserAppTaskData = null;
	 @Resource
	 private RStoreHouseData rStoreHouseData = null;
	 @Resource
	 private UserLocalAppMapper userLocalAppMapper = null;
	 @Resource
	 private UserAppTaskMapper userAppTaskMapper = null;
	 @Resource
	 private UserTaskLogMapper userTaskLogMapper = null;
	 @Resource
	 private ChargOrderMapper chargOrderMapper = null;
	 @Resource
	 private AppWealthRuleMapper appWealthRuleMapper = null;
	 @Resource
	 private StoreInfoService storeInfoService = null;
	 @Resource
	 private RStoreInfoData  rStoreInfoData = null;
	 
	 @Override
		public String chargHomePage(String token, String deviceId) {
		          ChargHomeRes homeRes = null;
		 try {
		
			 
			 
			 UserInfoBean infoBean = rUserLogBean.getRaw(token);
				
				if(infoBean == null){
					
					infoBean = userInfoBeanMapper.queryToken(token);
				}
				if(infoBean == null){
					return NotifyUtil.error(ErrorCodeEnum.NOLOGIN, "用户不存在");
					
				}
				 
				homeRes = new ChargHomeRes();
				//或者充电套餐列表
				 HashMap<String,String> map = new HashMap<String, String>();
				 map.put("deviceId", deviceId);
				// String chargHttps = "http://192.168.100.121:8080";
				 String taocan = SendUtils.doPost(chargHttps+"/kxzs/idea/list", map);
				 JSONObject json = new JSONObject(taocan);
				 int code = json.getInt("code");
				 if(code != 0){
					 if(code == 3102){
						 return NotifyUtil.error(ErrorCodeEnum.CHARGEERROR,json.getString("msg"));
					 }
					 return NotifyUtil.error(ErrorCodeEnum.OPERATERROE,json.getString("msg"));
				 }
				Object object = json.get("body");
				
				List<EntryVo> list= new Gson().fromJson(object.toString(), new TypeToken<List<EntryVo>>() {}.getType());
				homeRes.setEntrys(list);
				
				 //返回免费次数
				 List<UserTaskLog> free = isFree(infoBean, 2);
				 if(null == free ||  free.size() == 0){
					 homeRes.setFree(0);
				 }
				 homeRes.setFree(free.size());
				
				return NotifyUtil.success(homeRes);
				
		} catch (Exception e) {
			e.printStackTrace();

			return NotifyUtil.error(ErrorCodeEnum.OPERATERROE, e.getLocalizedMessage());
			
		}
		}
	 
	 
	 
	 
	@Override
	public String myTaskApps(String token) {
		try {
			 UserInfoBean infoBean = rUserLogBean.getRaw(token);
				
				if(infoBean == null){
					
					infoBean = userInfoBeanMapper.queryToken(token);
				}
				if(infoBean == null){
					return NotifyUtil.error(ErrorCodeEnum.NOLOGIN, "用户不存在");
					
				}
				//或者充电套餐列表
				
				
				//或者免费充电次数
				
				List<StoreAppRes> apps = getTypeByApps("free_charge_tag", infoBean,0,6);
				return NotifyUtil.success(apps);
				
		} catch (Exception e) {
			e.printStackTrace();

			return NotifyUtil.error(ErrorCodeEnum.OPERATERROE, e.getLocalizedMessage());
			
		}
	}
	//是否还有免费任务
    //有---查看今天是否使用过 --否 使用 修改状态标记以使用(只可以当前使用)
	//返回当前免费机会
	public List<UserTaskLog> isFree(UserInfoBean infoBean,Integer type ) {//type 1.只看今天 2.所有
		try {
			
			List<UserTaskLog> list = null;
			UserTaskLogExample logExample = new UserTaskLogExample();
			Criteria criteria = logExample.createCriteria();
			criteria.andUserIdEqualTo(infoBean.getId());
			if(type == 1){
				
		//		criteria.andUpdateTimeEqualTo(DateUtil.parse(DateUtil.format(new Date()))).andStatusEqualTo(t);
				criteria.andUpdateTimeBetween(DateUtil.gettwelve(),DateUtil.getzero()).andStatusEqualTo(t);
			}else if(type == 2){
				criteria.andStatusEqualTo(s);
			}
				list = userTaskLogMapper.selectByExample(logExample);
				return list;
				
		} catch (Exception e) {
			e.printStackTrace();
			LOGGER.error("-----------------------------------------"+e.getLocalizedMessage());
			return null;
			
		}
	 //     return list;
	}

	

	@Override
	public String boxOrder(String token) {
		try {
			 UserInfoBean infoBean = queryTokenByUser(token);
				if(infoBean == null){
					return NotifyUtil.error(ErrorCodeEnum.NOLOGIN, "用户不存在");
					
				}
				 Map<String,String> map = new HashMap<String, String>();
				 map.put("userId", infoBean.getId()+"");
				 String orders = SendUtils.doPost(chargHttps+"/kxzs/orders", map);
				 
				 JSONObject JSONObject = new JSONObject(orders);
				 int code = JSONObject.getInt("code");
				 if(code != 0){
					 
					 return NotifyUtil.error(ErrorCodeEnum.OPERATERROE,JSONObject.getString("msg"));
				 }
				Object object = JSONObject.get("body");
				
				List<BoxOrder> list= new Gson().fromJson(object.toString(), new TypeToken<List<BoxOrder>>() {}.getType());
			
				return NotifyUtil.success(list);
				
		} catch (Exception e) {
			e.printStackTrace();

			return NotifyUtil.error(ErrorCodeEnum.OPERATERROE, e.getLocalizedMessage());
			
		}
	}

    public ChargOrder isPassword(Long Uid,String orderNo, String deviceId){
    	 ChargOrderExample exa = new ChargOrderExample();
		 exa.createCriteria().andOutTradeNoEqualTo(orderNo).andUserIdEqualTo(Uid).andDeviceidEqualTo(deviceId);
		 List<ChargOrder> list11 = chargOrderMapper.selectByExample(exa);
		 if(null != list11 && list11.size() > 0){
			 ChargOrder order = list11.get(0);
			 return order;
			
		 }
		 return null;
    }
	
	
	@Override
	public String boxPassword(String token, String orderNo, String deviceId) {
		ChargOrder order = null;
		try {
			ChargPass chargPass = new ChargPass();
			UserInfoBean infoBean = queryTokenByUser(token);
			if(infoBean == null){
				return NotifyUtil.error(ErrorCodeEnum.NOLOGIN, "用户不存在");
				
			}
			String[] split = null;
			String ordernew = null;
			//支付成功
			if(!StringUtils.isBlank(orderNo)){
				int indexOf = orderNo.indexOf("_");
				if(indexOf != -1){
					split = orderNo.split("_");
					ordernew = split[0];
				}else{
					ordernew= orderNo;
				}
				
				}
			 order = isPassword(infoBean.getId(), ordernew, deviceId);

			 if(order == null ){
				 return NotifyUtil.error(ErrorCodeEnum.NOTFAIL, "订单不存在");
			 }
			 
			 
			
			//
			 short  s = 0;
			 
			 
			 ChargOrderExample example = new ChargOrderExample();
			 example.createCriteria().andOutTradeNoEqualTo(ordernew);
			 List<ChargOrder> list1 = chargOrderMapper.selectByExample(example);
			 if(null != list1 && list1.size() > 0){
				 
				  ChargOrder chargOrder = list1.get(0);
				 if(chargOrder.getType() == 2){
					 if(chargOrder.getStatus() == 2){
						 return NotifyUtil.error(ErrorCodeEnum.ISPAYFALL,"支付审核中");
					 }
					 if(chargOrder.getStatus() == 1){
						 return NotifyUtil.error(ErrorCodeEnum.ISPAYFALL,"支付失败");
					 }
				 }else if(chargOrder.getType() == 3){
					 List<UserTaskLog> free = isFree(infoBean, 2);
					 if(free != null && free.size() > 0){
						 List<UserTaskLog> free1 = isFree(infoBean, 1);
						 
						 if(null == free1 || free1.size() == 0){
							 
							 List<UserTaskLog> free2 = isFree(infoBean, 3);
						     //分佣金
							 
						     if(!DataFormatUntil.is5PCount(free2.size()) ){
						 	
								 if(free.get(0).getTaskType() == 1 || free.get(0).getTaskType() == 0){//发送佣金
									 
									 Map<String,String> map4 = new HashMap<String, String>();
									 map4.put("orderNo", chargOrder.getOutTradeNo());
									 
				 	  				 AppWealthRuleExample appWealthRuleExample = new AppWealthRuleExample();
									 appWealthRuleExample.createCriteria().andAppPackEqualTo("com.jihu.free").andStoreTypeEqualTo("2");
									 
									 
									 List<AppWealthRule> list2 = appWealthRuleMapper.selectByExample(appWealthRuleExample);
									 if(list2 == null || list2.size() == 0){
										 return NotifyUtil.error(ErrorCodeEnum.OPERATERROE,"分成比例不存在");
									 }

								     BigDecimal num = new BigDecimal(100);
									 StoreHouseAbs houseAbs = storeHouseMapper.selectByPack("com.jihu.free");
									 if(houseAbs == null){
										 return NotifyUtil.error(ErrorCodeEnum.OPERATERROE,"分成金额不存在");
									 }
									 String pri = num.multiply(houseAbs.getPrice())+"";
									 map4.put("baseMoney", pri.substring(0,pri.indexOf(".")));
									 if(list2.get(0).getStoreSubType().equals("1")){//代理
										 map4.put("agentRate", (list2.get(0).getAgentCityRate()+list2.get(0).getAgentCountyRate())+"");
										 map4.put("storeRate", list2.get(0).getStoreShopkeeperRate()+"");
										 
									 }else{
										 map4.put("jihuStoreRate", list2.get(0).getStoreShopkeeperRate()+"");
									 }
									 
									 if(list2.get(1).getStoreSubType().equals("2")){//门店
										 
										 map4.put("jihuStoreRate", list2.get(1).getStoreShopkeeperRate()+"");
									 }else{
										 map4.put("agentRate", (list2.get(1).getAgentCityRate()+list2.get(1).getAgentCountyRate())+"");
										 map4.put("storeRate", list2.get(1).getStoreShopkeeperRate()+"");
									 }
									 
									// map4.put("agentRate1", (list2.get(0).getAgentCityRate()+list2.get(0).getAgentCountyRate())+"");
									// map4.put("storeRate1", list2.get(0).getStoreShopkeeperRate()+"");
									 LOGGER.info("-----------------------------------------调取分佣参数"+new Gson().toJson(map4));
									 String fen = SendUtils.doPost(chargHttps+"/kxzs/freeChargeCommission", map4);
									 LOGGER.info("-----------------------------------------返回分佣"+new Gson().toJson(fen));
									 JSONObject fenj = new JSONObject(fen);
									 int fendou = fenj.getInt("code");
									 if(fendou != 0){
									     
										  NotifyUtil.error(ErrorCodeEnum.OPERATERROE,fenj.getString("msg"));
									 }
								 }
								 }
								 UserTaskLog userTaskLog = free.get(0);
								 userTaskLog.setStatus(t);
								 userTaskLog.setUpdateTime(new Date());
								 userTaskLogMapper.updateByPrimaryKey(userTaskLog);
							}
					 }
					
			
				 }
				 
				 Map<String,String> map = new HashMap<String, String>();
				 map.put("deviceId", deviceId);
				 map.put("orderNo", ordernew);
			//	 String pass = SendUtils.doPost("http://netcafe.jihustore.com/kxzs/device/code", map);
				 	 String pass = SendUtils.doPost(chargHttps+"/kxzs/device/code", map);
				 
				 JSONObject JSONObject = new JSONObject(pass);
				 int code = JSONObject.getInt("code");
				 if(code != 0){
					 
					 return NotifyUtil.error(ErrorCodeEnum.OPERATERROE,JSONObject.getString("msg"));
				 }
				 
				JSONObject object = JSONObject.getJSONObject("body");
				
				Object object2 = object.get("activeCode");
				
				List<ChargCode> list= new Gson().fromJson(object2.toString(), new TypeToken<List<ChargCode>>() {}.getType());
				
				Integer endt = (Integer) object.get("endTime");
		
			
				 chargPass.setEndTime(endt+"");
				 //chargPass.setEndTime("2019");
				 chargPass.setActiveCode(list);
				 LOGGER.info("-----------------------------------------返回充电密码"+new Gson().toJson(chargPass));
				 chargOrder.setChargcode(new Gson().toJson(list));
				 chargOrder.setEndtime(endt);
				 chargOrder.setStatus(s);
				 chargOrder.setUpdateTime(new Date());
				 chargOrderMapper.updateByPrimaryKey(chargOrder);
			 }else{
				 return NotifyUtil.error(ErrorCodeEnum.ISPAYFALL,"失败");
			 }
			
			     LOGGER.info("-----------------------------------------返回充电密码"+new Gson().toJson(chargPass));
			return NotifyUtil.success(chargPass);
		
		} catch (Exception e) {
			e.printStackTrace();
			LOGGER.error("-----------------------------------------"+e.getLocalizedMessage());
			return NotifyUtil.error(ErrorCodeEnum.OPERATERROE,e.getLocalizedMessage());
			
		}
	}


	@Override
	public String getOrder(String token, String ideaId, String deviceId,
			short type,String totalAmount, Integer plat) {
            try {
			
			UserInfoBean infoBean = queryTokenByUser(token);
			if(infoBean == null){
				return NotifyUtil.error(ErrorCodeEnum.NOLOGIN, "用户不存在");
				
			}
			List<UserTaskLog> free =null;
			  
			
			
			Integer plat1 = 1;
			if(plat != null){
				
				
				if(plat == 1){
					
					plat1 =2;
				}else if(plat == 2){
					plat1 =1;
				}
			}
             Map<String,String> map1 = new HashMap<String, String>();
			 Map<String,String> map = new HashMap<String, String>();
			 map.put("deviceId", deviceId);
			 map.put("userId", infoBean.getId()+"");
			 map.put("ideaId", ideaId);
			 String order = null;
			 String ideas = null;
			 Integer cost = 0;
			 Integer idea = 0;
			 if(type == 3){
				 
				 Map<String,String> mainv = new HashMap<String, String>();
				 mainv.put("deviceId", deviceId);
				 String  invitation = SendUtils.doPost(chargHttps+"/kxzs/invitationCode", mainv);
				 JSONObject JSONOinv = new JSONObject(invitation);
				 
				 int code = JSONOinv.getInt("code");
				 
				 if(code != 0){
					 
				
						 return NotifyUtil.error(ErrorCodeEnum.CHARGEERROR,JSONOinv.getString("msg"));
				 }
				 JSONObject body = JSONOinv.getJSONObject("body");
				 String invitationCode = body.getString("invitationCode");//门店邀请码
				 //如果 门店今日注册超过30 个,就不送免费
                   Integer regis =   userInfoBeanMapper.queryDay30(invitationCode,DataUtils.formatDate()+" 00:00:00",DataUtils.formatDate()+" 23:59:59");
                   LOGGER.info("-----------------------------------------今日注册数"+regis);
                   if(regis > 30){
                	   
                	UserTaskLog   taskLog = userTaskLogMapper.queryReg(infoBean.getId(),t);//返回首次注册
                	if(taskLog != null){
                		
                	
   					taskLog.setTaskNum(0);
   					taskLog.setTaskType(s);
   					taskLog.setStatus(y);
   					taskLog.setRemark("今日注册超过30");
   					taskLog.setUpdateTime(new Date());
   					try {
						
   					   userTaskLogMapper.updateByPrimaryKey(taskLog);
   					 LOGGER.info("-----------------------------------------今日免费数"+free);
   					return NotifyUtil.error(ErrorCodeEnum.NOTFREE,"请下载app获取免费次数"); 
					} catch (Exception e) {
						
						e.printStackTrace();
					}
                	}   
                	   
                   } 
                   
                   free = isFree(infoBean,2);
      				 
           			
      			   if(null == free || free.size() == 0){
      					 return NotifyUtil.error(ErrorCodeEnum.NOTFREE,"请下载app获取免费次数");
      			   }
      				 
      			   List<UserTaskLog> free1 = isFree(infoBean, 1);
      			   if(free1.size() > 0){
      						 return NotifyUtil.error(ErrorCodeEnum.USEDFREE,"一天只能免费用一次哦");
      				 }
				
				  UserTaskLog taskLog = free.get(0);
				  Integer f = 1;
				  if(taskLog.getTaskType() == 1){
					  f = 2;
				  }
				  map.put("type", f+"");//1 下载 2注册
				  order = SendUtils.doPost(chargHttps+"/kxzs/createFreeOrder", map);
			 }else{
				  order = SendUtils.doPost(chargHttps+"/kxzs/createOrder", map);
				  
				  Map<String,String> map2 = new HashMap<String, String>();
				  
					 map2.put("ideaId", ideaId);
					 ideas = SendUtils.doPost(chargHttps+"/kxzs/idea/detail", map);
					 
					 JSONObject JSONOb = new JSONObject(ideas);
					 
					 int code = JSONOb.getInt("code");
					 
					 if(code != 0){
							 return NotifyUtil.error(ErrorCodeEnum.CHARGEERROR,JSONOb.getString("msg"));
					 }
					  JSONObject body = JSONOb.getJSONObject("body");
					 
					  cost = (Integer) body.get("cost");//
					  
					  totalAmount = cost * 0.01+"";
					  
					  idea = (Integer) body.get("idea");//分钟
					   
				  
			 }
			 
			 
               if(StringUtils.isBlank(order)){
				 
				 return NotifyUtil.error(ErrorCodeEnum.CHARGEERROR);
			 }
               
			 JSONObject JSONObject = new JSONObject(order);
			 
			 int code = JSONObject.getInt("code");
			 
			 if(code != 0){
				 
			
					 return NotifyUtil.error(ErrorCodeEnum.CHARGEERROR,JSONObject.getString("msg"));
			 }
			 JSONObject body = JSONObject.getJSONObject("body");
			 String orderNo = body.getString("orderNo");
			 String invitationCode = body.getString("invitationCode");//门店邀请码
			 
			 if(StringUtils.isBlank(infoBean.getFirstInviteCode())){//是空的直接绑定
				 
				 StoreInfoBean storeInfo = rStoreInfoData.getStoreInfo(invitationCode);
				 if(storeInfo == null){
					 
				 storeInfoService.queryInvite(invitationCode);
				 }
				 storeInfo= rStoreInfoData.getStoreInfo(invitationCode);
                     if(storeInfo == null){
					 
                    	 return NotifyUtil.error(ErrorCodeEnum.OPERATERROE,"设备码不存在");
				 }
                    
                
                   
				   accountService.bindingInvite(token, invitationCode, storeInfo.getStoreId()+"", storeInfo.getStoreName(),1);
			 }
			 String s =  orderNo+"_"+rCharBoxData.increment(new Date().getTime());
			// String orderNo=orderNo+new Date().getSeconds();
			 map1.put("orderNo", orderNo);
			
		     
			 if(type == 2){
				
				 setChargOrder("", "", totalAmount,orderNo, type, deviceId, infoBean,2,ideaId,cost,idea);
				//实例化客户端d
				 AlipayClient alipayClient = new DefaultAlipayClient(aliGateway, aliAppid, privateKey, "json", "UTF-8", alipayBublicKey, "RSA2");
				 //实例化具体API对应的request类,类名称和接口名称对应,当前调用接口名称：alipay.trade.app.pay
				 AlipayTradeAppPayRequest request = new AlipayTradeAppPayRequest();
				 //SDK已经封装掉了公共参数，这里只需要传入业务参数。以下方法为sdk的model入参方式(model和biz_content同时存在的情况下取biz_content)。
				 AlipayTradeAppPayModel model = new AlipayTradeAppPayModel();
				 model.setBody("快下充电宝");
				 model.setSubject("充电宝");
				 model.setOutTradeNo(s);
				 model.setTimeoutExpress("30m");
				 
				 
				 model.setTotalAmount(totalAmount);
				 model.setProductCode("QUICK_MSECURITY_PAY");
				 request.setBizModel(model);
				 request.setNotifyUrl(aliHttps+"/ChargBox/alipay_notify_url");
				 try {
				         //这里和普通的接口调用不同，使用的是sdkExecute
				         AlipayTradeAppPayResponse response = alipayClient.sdkExecute(request);
				     //    System.out.println(response.getBody());//就是orderString 可以直接给客户端请求，无需再做处理。
				         
				        
				         return  NotifyUtil.success(response.getBody());
				     } catch (AlipayApiException e) {
				         e.printStackTrace();
				 }
				 
				 
				 
			 }
			 
			 if(type == 5){//支付宝小程序
					
				 setChargOrder("", "", totalAmount,orderNo, type, deviceId, infoBean,2,ideaId,cost,idea);
				//实例化客户端 
				 AlipayClient alipayClient = new DefaultAlipayClient(aliGateway, "2019092367692918", private_key, "json", "UTF-8", alipay_public_key, "RSA2");
				 //实例化具体API对应的request类,类名称和接口名称对应,当前调用接口名称：alipay.trade.app.pay
				 AlipayTradeCreateRequest request = new AlipayTradeCreateRequest();
				 request.setBizContent("{" +
							"\"out_trade_no\":\""+s+"\"," +
							"\"total_amount\":\""+totalAmount+"\"," +
							 "\"subject\":\"充电宝支付宝\"," +
							 "\"buyer_id\":\""+infoBean.getAliUserId()+"\"" +
							"  }");
				 
				 request.setNotifyUrl(aliHttps+"/ChargBox/alipay_notify_url");
				 try {
				     //这里和普通的接口调用不同，使用的是sdkExecute
					 
					 AlipayTradeCreateResponse  response = alipayClient.execute(request);
				     if(response.isSuccess()){
				    	 Map<String,String> map2 = new HashMap<String, String>();
						 map2.put("outtradeNo", s);
						 map2.put("tradeNo", response.getTradeNo());
				    	 return  NotifyUtil.success(map2);
				     }else{
				    	 return  NotifyUtil.error(ErrorCodeEnum.OPERATERROE);
				     }
				    
				 } catch (AlipayApiException e) {
				 
					 e.printStackTrace();
				 
				 }
			 }
			 if(type == 1 || type == 4){//微信
				 Map<String,String> map3 = new HashMap<String, String>();
				 Map<String,String> map2 = new HashMap<String, String>();
				 map2.put("deviceId", deviceId);
				 map2.put("ideaId", ideaId);
				 
				 map2.put("platform", plat1+"");
				 map2.put("userThirdPartId", infoBean.getId()+"");
				 map2.put("ipAddress", "192.168.0.5");
				 String wxbody =null;
				 if(type == 4){
					 
					 map2.put("openid", infoBean.getOpenId());
					 LOGGER.info("===============小程序参数:"+map2.toString());
				//	 wxbody = SendUtils.doPost("http://netcafe.jihustore.com/kxzs/wxPayParamsByMP", map2);
					 wxbody = SendUtils.doPost(chargHttps+"/kxzs/wxPayParamsByMP", map2);
					 LOGGER.info("===============小程序获取延签值:"+wxbody);
				 }else{
					 map2.put("ipAddress", "192.168.0.5");
					 wxbody = SendUtils.doPost(chargHttps+"/kxzs/wxPayParams", map2);
				 }
				 
				 
				 JSONObject JSONOb = new JSONObject(wxbody);
				 
				 int code1 = JSONOb.getInt("code");
				 
				 if(code1 != 0){
					 
					 return NotifyUtil.error(ErrorCodeEnum.OPERATERROE,JSONOb.getString("msg"));
				 }
				 JSONObject body1 = JSONOb.getJSONObject("body");
			//	 cost = (Integer) body.get("cost");//时长
			//	 idea = (Integer) body.get("idea");//分钟
				 String timeStamp = body1.getString("timeStamp");
				 String orderNo1 = body1.getString("orderNo");
				 if(type == 1){
					 String packageValue = body1.getString("packageValue");
					 String appId = body1.getString("appId");
					 String sign = body1.getString("sign");
					 String partnerId = body1.getString("partnerId");
					 String prepayId = body1.getString("prepayId");
					 String nonceStr = body1.getString("nonceStr");
					 map3.put("timeStamp", timeStamp);
					 map3.put("orderNo", orderNo1);
					 map3.put("packageValue", packageValue);
					 map3.put("appId", appId);
					 map3.put("sign", sign);
					 map3.put("partnerId", partnerId);
					 map3.put("prepayId", prepayId);
					 map3.put("nonceStr", nonceStr);
				 }else{
					 String packageValue = body1.getString("package");
					 String paySign = body1.getString("paySign");
					 String appId = body1.getString("appId");
					 String signType = body1.getString("signType");
					 String nonceStr = body1.getString("nonceStr");
					 map3.put("timeStamp", timeStamp);
					 map3.put("orderNo", orderNo1);
					 map3.put("package", packageValue);
					 map3.put("appId", appId);
					 map3.put("sign", paySign);
					 map3.put("signType", signType);
					 map3.put("nonceStr", nonceStr);
				 }
				 setChargOrder("", "", totalAmount,orderNo1, type, deviceId, infoBean,2,ideaId,cost,idea);
				 return NotifyUtil.success(map3);
			 }
		
			 if(type == 3){//免费
				 
				 setChargOrder("", "", totalAmount,orderNo, type, deviceId, infoBean,2,ideaId,cost,idea);
				 
				 NotifyUtil.success(map1);
				}
			   return NotifyUtil.success(map1);
		
		} catch (Exception e) {
			e.printStackTrace();
			return NotifyUtil.error(ErrorCodeEnum.OPERATERROE);
			
		}
	}
	//修改充电宝订单状态
	public void setChargOrder(String tradeNo,String sellerId,String totalAmount,String orderNo,short type,String deviceId,UserInfoBean infoBean, Integer status,String ideaId,Integer cost,Integer idea){
		 
		 ChargOrder chargOrder = null;
		 try {
			 ChargOrderExample example = new ChargOrderExample();
			 example.createCriteria().andOutTradeNoEqualTo(orderNo);
			 List<ChargOrder> list = chargOrderMapper.selectByExample(example);
			 if(null != list && list.size() > 0){
				  chargOrder = list.get(0);
			 }else{
				 
				  chargOrder = new ChargOrder();
			 }
		     if(tradeNo != null){
				  chargOrder.setTradeNo(tradeNo);
				  }
		    if(totalAmount != null){
				  chargOrder.setTotalAmount(totalAmount);
				  }else{
					  chargOrder.setTotalAmount("0"); 
				  }
			if(sellerId != null){
				  chargOrder.setSellerId(sellerId);
				  }
			 if(deviceId != null && deviceId != ""){
				 
				 chargOrder.setDeviceid(deviceId);
			 }
			 if(ideaId != null){
				 chargOrder.setIdeaid(Integer.valueOf(ideaId));
			 }
			 chargOrder.setOutTradeNo(orderNo);
			 if(cost != 0 && idea != 0){
				 chargOrder.setCost(cost);
				 chargOrder.setIdea(idea);
			 }
			 chargOrder.setStatus(status.shortValue());
			 chargOrder.setType(type);
			 if(infoBean !=  null){
				 chargOrder.setUserId(infoBean.getId());
			 }
			 if(chargOrder.getId()== null){//修改
				 
				 chargOrder.setCreateTime(new Date());
				 chargOrderMapper.insertSelective(chargOrder);
			 }else{
				 chargOrder.setUpdateTime(new Date());
				 chargOrderMapper.updateByPrimaryKey(chargOrder);
			 }
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
	}

  /*  public static void main(String[] args) {
    	 BigDecimal num22 = new BigDecimal(100+"");
    	 BigDecimal s = new BigDecimal(0.80);
    	 String multiply = num22.multiply(s)+"";
    	 
    	 String substring = multiply.substring(0,multiply.indexOf("."));
    	 System.out.println(substring);
	}*/
	@Override
	public void alipayUrl(Map<String, String> map) {
		// TODO Auto-generated method stub
		Integer status = 2;
		try {
			String tradeNo = map.get("trade_no");
			String sellerId = map.get("seller_id");
			String totalAmount = map.get("total_amount");
			String orderNo = map.get("out_trade_no");
			String tradeStatus = map.get("trade_status");
			if(tradeStatus.equals("TRADE_SUCCESS") ){//代表
				status =0;
				
			}else{
				//失败
				status =1;
			}
			if(!StringUtils.isBlank(orderNo)){
				String[] split = orderNo.split("_");
				 ChargOrderExample example = new ChargOrderExample();
				 example.createCriteria().andOutTradeNoEqualTo(split[0]);
				 List<ChargOrder> list = chargOrderMapper.selectByExample(example);
				 if(list != null && list.size() > 0){
					 
					 Map<String,String> map1 = new HashMap<String, String>();
					 map1.put("deviceId", list.get(0).getDeviceid());
					 map1.put("orderNo", list.get(0).getOutTradeNo());
					 map1.put("ideaId", list.get(0).getIdeaid()+"");
					 map1.put("userId", list.get(0).getUserId()+"");
					 if(StringUtils.isNotBlank(list.get(0).getTotalAmount())){
						 
						 String ss  = Double.valueOf(list.get(0).getTotalAmount())*100+"";
						 map1.put("amount", ss.substring(0,ss.indexOf(".")));
						 String issucc = SendUtils.doPost(chargHttps+"/kxzs/alipayNotify", map1);
						 LOGGER.error("-----------------------------------------回调函数===B端网吧回调:"+issucc);
						 JSONObject JSONObject = new JSONObject(issucc);
						 int code = JSONObject.getInt("code");
						 if(code != 0){
						 }
					 }
					 
					 short s = 2;
					 setChargOrder(tradeNo, sellerId, totalAmount, split[0], s, "", null,status,null,0,0);
				 }
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	





	@Override
	public String refPass(String token, String deviceId, String orderNo) {

		 Map<String,String> map = new HashMap<String, String>();
		UserInfoBean infoBean = queryTokenByUser(token);
		if(infoBean == null){
			return NotifyUtil.error(ErrorCodeEnum.NOLOGIN, "用户不存在");
			
		}
		String[] split = null;
		String ordernew = null;
		//支付成功
		if(!StringUtils.isBlank(orderNo)){
			int indexOf = orderNo.indexOf("_");
			if(indexOf != -1){
				split = orderNo.split("_");
				ordernew = split[0];
			}else{
				ordernew= orderNo;
			}
			
			}
		map.put("deviceId", deviceId);
		map.put("orderNo", ordernew);
		String sss = SendUtils.doPost(chargHttps+"/kxzs/refresh/code", map);
		 
		JSONObject JSONOb = new JSONObject(sss);
		 
		 int code1 = JSONOb.getInt("code");
		 
		 if(code1 != 0){
			 
			 return NotifyUtil.error(ErrorCodeEnum.OPERATERROE,JSONOb.getString("msg"));
		 }
//		  JSONObject body1 = JSONOb.getJSONObject("body");
//		  cost = (Integer) body.get("cost");//时长
//		  idea = (Integer) body.get("idea");//分钟
//		   
//		 
//		 String timeStamp = body1.getString("timeStamp");
//		 String orderNo1 = body1.getString("orderNo");
//		 String packageValue = body1.getString("packageValue");
		
		 return NotifyUtil.success();
	}

	
	
	@Override
		
	public String isCharg(String token) {
		Map<String,String> map = new HashMap<String, String>();
		UserInfoBean infoBean = queryTokenByUser(token);
		if(infoBean == null){
			return NotifyUtil.error(ErrorCodeEnum.NOLOGIN, "用户不存在");
			
		}
		short s = 0;
		ChargOrder order = null;
		ChargOrderExample example = new ChargOrderExample();
		example.createCriteria().andUserIdEqualTo(infoBean.getId());//密码获取成功
		example.setOrderByClause(" create_time desc");
		List<ChargOrder> list = chargOrderMapper.selectByExample(example);
		if(null == list || list.size() == 0){
			 map.put("orderNo", "");
			 return NotifyUtil.success(map);
		}
		
		 order = list.get(0);
		/* Integer endtime = order.getEndtime();
		 
		 Integer date = Integer.valueOf(String.valueOf(new Date().getTime()).substring(0, 10)); 
		 if(date > endtime){//服务结束
			 short t = 3;
			 order.setStatus(t);
			 order.setUpdateTime(new Date());
			 chargOrderMapper.updateByPrimaryKey(order);
			 map.put("orderNo", "");
			 return NotifyUtil.success(map);
		 }*/
		 
		 //服务是否结束
		 Map<String,String> map1 = new HashMap<String, String>();
		 map1.put("deviceId", order.getDeviceid());
		 map1.put("orderNo", order.getOutTradeNo());
		 String pass = SendUtils.doPost(chargHttps+"/kxzs/device/code", map1);
		 try {
			 JSONObject JSONObject = new JSONObject(pass);
			 int code = JSONObject.getInt("code");
			 if(code != 0){//服务已经结束
				 short t = 3;
				 order.setStatus(t);
				 order.setUpdateTime(new Date());
				 chargOrderMapper.updateByPrimaryKey(order);
				 map.put("orderNo", "");
				 return NotifyUtil.success(map);
			 }
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
		 

		     map.put("orderNo", order.getOutTradeNo());
		     map.put("deviceId", order.getDeviceid());
		 return NotifyUtil.success(map);
	}

	@Override
	public void ChargOver(String token, String orderNo) {
		UserInfoBean infoBean = queryTokenByUser(token);
		if(infoBean != null){
			
			
		
		short s = 0;
		ChargOrderExample example = new ChargOrderExample();
		example.createCriteria().andOutTradeNoEqualTo(orderNo);//密码获取成功

		List<ChargOrder> list = chargOrderMapper.selectByExample(example);
		try {
			
			if(null != list && list.size() > 0){
				short t= 3;
				ChargOrder	order = list.get(0);
				order.setStatus(t);
				order.setUpdateTime(new Date());
				chargOrderMapper.updateByPrimaryKey(order);
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		}
	}

	public String app_id = "20190005";//我方分配应用id
	public String app_version = "1.1.1";//此文档固定为1.1.1
	public String ad_type_id = "20190005";//我方分配广告位id
	public String ad_size = "1080x1920";//广告位尺寸，暂不做匹配
	public String host_package_name = "com.jihu.queckdown";//宿主包名
	public String imei;//设备imei
	public String imsi;//设备imsi
	public String android_id;//设备Android Id
	public String mac;//设备mac地址
	public String device_type="1";//设备类型 手机：1 此处为固定值
	public String os = "1";//设备系统 android：1 ios：2 暂不支持ios广告，此处为固定值
	public String os_version;//设备版本
	public String os_version_code;//设备版本号
	public String vendor;//设备厂商
	public String model;//设备型号
	public String screen_size;//设备屏幕尺寸
	public String ip;//客户端ip如果是服务器对接，一定要传客户端ip,，否则数据会被稽核
	public String connetion_type = "100";//设备网络状态 只限于wifi状态下 此处为固定值
	public String type = "2";	//列表类型 应用：1 	游戏：2 推荐：3
	public String page_size;//翻页参数，一次请求返回数量，上限50
	public String offset;//翻页参数，第一次请求可以不传，后续请求翻页需要原样返回pageContext字段
	
	@Override
	public String thirdPartyApps(String token, ThirdPartyAppsRes res) {
		UserInfoBean infoBean = queryTokenByUser(token);
		if(infoBean == null){
			return NotifyUtil.error(ErrorCodeEnum.NOLOGIN, "用户不存在");
			
		}
		
		 // TODO Auto-generated method stub
		 Map<String,Object> map = new HashMap<String, Object>();
		 map.put("app_id", "20190005");
		 map.put("app_version", "1.1.1");
		 map.put("ad_type_id", "20190005");
		 map.put("ad_size", "1080x1920");
		 map.put("host_package_name","com.jihu.queckdown");
		 map.put("imei", res.getImei());
		 map.put("imsi", res.getImsi());
		 map.put("android_id",res.getAndroid_id());
		 map.put("mac",res.getMac());
		 map.put("device_type", 1);
		 map.put("os",1);
		 map.put("os_version", res.getOs_version());
		 map.put("os_version_code",Integer.valueOf(res.getOs_version_code()));
		 map.put("vendor", res.getVendor());
		 map.put("model", res.getModel());
		 map.put("screen_size", res.getScreen_size());
		 map.put("ip", res.getIp());
		 map.put("connetion_type", 100);
		 map.put("type", 1);
		 map.put("page_size", 10);
		 LOGGER.info("---------------------第三方请求参数"+new Gson().toJson(map));
		 String param = "json="+""+new Gson().toJson(map);
		 List<BoxStoreAppRes> apps = new ArrayList<BoxStoreAppRes>();
		 String sdlist =  HttpRequest.sendGet("http://cpd.liyanmobi.com:808/yyb/list", param);
		 LOGGER.info("---------------------第三方应用市场刚返回值"+sdlist);
		 List<PartyApps> list = new ArrayList<PartyApps>();
		 if(StringUtils.isNotBlank(sdlist)){
				JSONObject JSONObject = new JSONObject(sdlist);
				Integer code = (Integer) JSONObject.get("code");
				if(Integer.valueOf(code) == 200) {
					
					Object ad_list = JSONObject.get("list");
					if(ad_list != null){
						
						list= new Gson().fromJson(ad_list.toString(), new TypeToken<List<PartyApps>>() {}.getType());
					}
					
				}
		    for (PartyApps cpdApps : list) {
			
				BoxStoreAppRes appRes = new BoxStoreAppRes();
				appRes.setId(0);
				appRes.setAppName(cpdApps.getApp_name());
				appRes.setAppPake(cpdApps.getPackage_name());
				appRes.setAppType(cpdApps.getDescription());//cpd
				appRes.setImg(cpdApps.getIcon());
				appRes.setUrl(cpdApps.getUrl());
				if(getUserTask(infoBean.getId(), cpdApps.getPackage_name())){
					continue;
				}
				if(userAppTaskMapper.queryPackAndUserIdByStatus(cpdApps.getPackage_name(), infoBean.getId()) != null){
					
					appRes.setLocalstatus(1);
				};
				appRes.setClick(cpdApps.getClick());
				appRes.setShow(cpdApps.getShow());
				appRes.setDownload(cpdApps.getDownload());
				appRes.setInstall(cpdApps.getInstall());
				appRes.setModel("1");
				appRes.setType(3001);
				appRes.setSource(1);
				appRes.setPid(cpdApps.getPid());
				//--存入redis
				StoreHouse st = new StoreHouse();
				st.setAppDesc(cpdApps.getDescription());
				st.setAppPack(cpdApps.getPackage_name());
				st.setAppName(cpdApps.getApp_name());
				st.setIsSelf(3001);
				st.setAppVersion(cpdApps.getVersion());
				st.setAppUrl(cpdApps.getUrl());
				short sy = 3001;
				st.setAppType(sy);
				st.setAppUrlImg(cpdApps.getIcon());
				rStoreHouseData.setAppPack(st);
			    apps.add(appRes);
			}
		 }
		return NotifyUtil.success(apps);
	}



    
	@Override
	public String thirdPartyAppsDatail(String token ,String appPack, ThirdPartyAppsRes res) {
		
		UserInfoBean infoBean = queryTokenByUser(token);
		if(infoBean == null){
			return NotifyUtil.error(ErrorCodeEnum.NOLOGIN, "用户不存在");
			
		}
		StoreHouseAbs abs = new  StoreHouseAbs();
		 Map<String,Object> map = new HashMap<String, Object>();
		 
		 map.put("app_id", "20190005");
		 map.put("app_version", "1.1.1");
		 map.put("ad_type_id", "20190005");
		 map.put("ad_size", "1080x1920");
		 map.put("host_package_name","com.jihu.queckdown");
		 map.put("imei", res.getImei());
		 map.put("imsi", res.getImsi());
		 map.put("android_id",res.getAndroid_id());
		 map.put("mac",res.getMac());
		 map.put("device_type", 1);
		 map.put("os",1);
		 map.put("os_version", res.getOs_version());
		 map.put("os_version_code",Integer.valueOf(res.getOs_version_code()));
		 map.put("vendor", res.getVendor());
		 map.put("model", res.getModel());
		 map.put("screen_size", res.getScreen_size());
		 map.put("ip", res.getIp());
		 map.put("connetion_type", 100);
		 map.put("type", 1);
		 map.put("action_source", "list");
		 map.put("target_package_name", appPack.split(","));
		 
		 String param = "json="+""+new Gson().toJson(map);
		 try {
			 String sdlist =  HttpRequest.sendGet("http://cpd.liyanmobi.com:808/yyb/detail", param);
			 if(sdlist != null){
					JSONObject JSONObject = new JSONObject(sdlist);
					Integer code = (Integer) JSONObject.get("code");
					if(Integer.valueOf(code) == 200) {
						  JSONObject data = JSONObject.getJSONObject("detail");
						 
						 
						if(data != null){
							String pid = (String) data.get("pid");
							int downTimes = data.getInt("app_down_count");
							String appUrlImg = (String)data.get("icon");
							String appName = (String)data.get("app_name");
							String package_name = (String)data.get("package_name");
							String appUrl = (String)data.get("url");
							
						    int appSize = data.getInt("file_size");
							String appVersion = (String)data.get("version");
							String appDesc = (String)data.get("description");
							String apptype = (String)data.get("new_feature");
							String click = (String)data.get("click");
							JSONArray imgs = data.getJSONArray("image");
							
							String imgs2 = getImgs(imgs);
							
							abs.setAppDesc(appDesc);
							abs.setAppDetailsPng(imgs2);
							abs.setAppName(appName);
							abs.setAppPack(package_name);
							abs.setAppSize(appSize+"");
							abs.setApptype(apptype);
							abs.setAppUrl(appUrl);
							abs.setAppUrlImg(appUrlImg);
							abs.setAppVersion(appVersion);
							abs.setIsSelf(3001);
							abs.setType(3001);
							abs.setClick(click);
							abs.setDownTimes("");
							if(getLocalApp(infoBean.getId(), package_name)){
								
								 abs.setLocalstatus(1);
								 
							    }else{
							    	
							     abs.setLocalstatus(0);
							     
							    }
							
						}
					}
				}
		} catch (Exception e) {
			e.printStackTrace();
		}
		  //应用推荐类型列表.
			List<StoreAppRes> apps = getTypeByApps("local_app_recommend", infoBean,0,10);
			abs.setApps(apps);
	
		return  NotifyUtil.success(abs);
	}
    public  String  getImgs(JSONArray jsonArray) {
    	//1. 创建JSONArray对象
//    			String json ="['http://pp.myapp.com/ma_pic2/0/shot_10936_1_1536066226/0', 'http://pp.myapp.com/ma_pic2/0/shot_10936_2_1536066226/0']";
//    			JSONArray jsonArray = new JSONArray(json); 
    			
    			
    			
    			//2. JSONArray转String
    		  
				
				String string2 = jsonArray.toString();
				String replace1 = string2.replace("[","");
				String res = replace1.replace("]","");
				
				String[] pngs = res.split(",");
				  StringBuffer buffer = new StringBuffer();
	        	     for (int i = 0; i < pngs.length; i++) {
	        	 		String ss = pngs[i];
	        	 		
	        	 		String newStr = ss.substring(1, ss.length()-1);

	        	 		
	        	 		if(i == pngs.length - 1 ){
	        	 			buffer.append(newStr);
	        	 		}else{
	        	 			buffer.append(newStr+",");
	        	 		}
	        	 		
	        	 		
	        	 	}
    			return buffer.toString();
    	
    }
    
}