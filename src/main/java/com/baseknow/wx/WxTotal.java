package com.baseknow.wx;

import me.chanjar.weixin.common.api.WxConsts;
import me.chanjar.weixin.mp.api.WxMpInMemoryConfigStorage;
import me.chanjar.weixin.mp.api.WxMpService;
import me.chanjar.weixin.mp.api.impl.WxMpServiceImpl;
import me.chanjar.weixin.mp.bean.result.WxMpOAuth2AccessToken;
import me.chanjar.weixin.mp.bean.result.WxMpUser;
import me.chanjar.weixin.mp.bean.template.WxMpTemplateData;
import me.chanjar.weixin.mp.bean.template.WxMpTemplateMessage;

/**
 * 微信公众号开发模板
 *此微信公众号开发是引入了第三方微信组件；
 * 确保我们已经引入如下jar
 * 		微信开发Java SDK公共模块
 * 		<dependency>
 * 		<groupId>com.github.binarywang</groupId>
 * 		<artifactId>weixin-java-common</artifactId>
 * 		<version>3.1.0</version>
 * 		</dependency>
 * 		微信公众号Java SDK
 * 		<dependency>
 * 		<groupId>com.github.binarywang</groupId>
 * 		<artifactId>weixin-java-mp</artifactId>
 * 		<version>3.1.0</version>
 * 		</dependency>
 *
 * 	此类只提供实例性的代码，基本上是生产中的操作：
 * 	测试时候，请添加公众号测试号进行测试
 */
public class WxTotal {

        private static WxMpService wxMpService;

    /**
     * 这个static 静态方法，在实际的生产中，请配置在xml中，让spring进行整合，进行持久化操作
     *生产配置如下：
     *
     * 	  <bean id="config" class="me.chanjar.weixin.mp.api.WxMpInMemoryConfigStorage">
     *     	<property name="appId" value="${wx.appId}" />
     * 		<property name="secret" value="${wx.secret}" />
     *  <!--将配置信息注入到service中-->
     *     </bean>
     *     <bean id="wxMpService" class="me.chanjar.weixin.mp.api.impl.WxMpServiceImpl">
     *     	<property name="wxMpConfigStorage" ref="config"></property>
     *     </bean>
     */
    static {

        wxMpService =new WxMpServiceImpl();
        WxMpInMemoryConfigStorage config =new WxMpInMemoryConfigStorage();
        config.setAppId("wx426aad126775582c");
        config.setSecret("d79b69215c50cee0c848415eb34c659a");
        wxMpService.setWxMpConfigStorage(config);
    }


    /**
     * 发送模板消息操作：
     * 提供事例代码，在生产中也是这样
     * access_token 会自动进行存储，并不是每次都会获取
     * addData 是我们需要发送的消息： key  value color
     * {{first.DATA}}
     * 我的支付渠道:{{keyword1.DATA}}
     * 物流信息：{{keyword2.DATA}}
     * 目前联系电话：{{keyword3.DATA}}
     * 购买公司：{{keyword4.DATA}}
     */

    public static  void sendTemplate() throws Exception{

        WxMpTemplateMessage templateMessage = WxMpTemplateMessage.builder().toUser("o91wT1ty9ClvlAx_Fl9LRE5RZsgg")
                .templateId("P9GkNJd7ziaX3CQV1muBRKz2vEZzne_ByGZolsZeL48")
                .url("https://www.baidu.com")
                .build();
        templateMessage.addData(new WxMpTemplateData("first", "\t mmp", "red"));
        templateMessage.addData(new WxMpTemplateData("keyword1", "\t wo1", "red"));
        templateMessage.addData(new WxMpTemplateData("keyword2", "\t wo2", "red"));
        templateMessage.addData(new WxMpTemplateData("keyword3", "\t wo3", "red"));
        templateMessage.addData(new WxMpTemplateData("keyword4", "\t wo3", "red"));

        String templateId=wxMpService.getTemplateMsgService().sendTemplateMsg(templateMessage);
        System.out.println(templateId);
    }


    /**
     * 这个myurl 会接收到一个微信发过来的code 码
     * 拿到这个code 码getWxUserInfo(code) 就可以获得用户的信息了
     * @param myUrl
     * @return
     */
    public static String redirect(String myUrl){
        String url=wxMpService.
                oauth2buildAuthorizationUrl(myUrl, WxConsts.OAuth2Scope.SNSAPI_USERINFO, null);
        System.out.println(url);
        return url;
    }
    /**
     * 通过code 获取用户的信息
     * WxMpOAuth2AccessToken// 维护了openId ,联合登录的unionId ,accessToken 信息
     * @throws Exception
     */
    public static WxMpUser getWxUserInfo(String wxCode) throws Exception{
        WxMpOAuth2AccessToken tokenInfo =
                wxMpService.oauth2getAccessToken(wxCode);

        WxMpUser wxMpUser = wxMpService.oauth2getUserInfo(tokenInfo,null);
        return wxMpUser;
    }



    public static void main(String [] args) throws Exception{

    }
}
