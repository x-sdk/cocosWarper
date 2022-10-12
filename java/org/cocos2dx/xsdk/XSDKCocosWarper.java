package org.cocos2dx.xsdk;

import com.seantone.xsdk.core.XSDK;
import com.seantone.xsdk.core.impl.IPushCallback;
import com.seantone.xsdk.core.impl.IXSDKCallback;
import com.seantone.xsdk.core.impl.ad.IBannerAd;
import com.seantone.xsdk.core.impl.ad.IBannerAdEventCallBack;
import com.seantone.xsdk.core.impl.ad.INativeAd;
import com.seantone.xsdk.core.impl.ad.INativeAdEventCallBack;
import com.seantone.xsdk.core.impl.ad.IRewardedVideoAd;
import com.seantone.xsdk.core.impl.ad.IRewardedVideoAdEventCallBack;

import org.cocos2dx.lib.Cocos2dxActivity;
import org.cocos2dx.lib.Cocos2dxJavascriptJavaBridge;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class XSDKCocosWarper {
    //================================================================================
    static boolean isInitContext = false;
    static private Map<Integer, Object> mObjectMap = new HashMap<Integer, Object>();
    static private Integer objectKeyTmp = 0;

    static Integer getObjectKey() {
        objectKeyTmp += 1;
        return objectKeyTmp;
    }

    static Object getObjectByKey(Integer key) {
        return mObjectMap.get(key);
    }

    static Object setObjectByKey(Integer key, Object object) {
        return mObjectMap.put(key, object);
    }

    static Object removeObjectByKey(Integer key) {
        return mObjectMap.remove(key);
    }

    //================================================================================
    static void runScript(String script) {
        Cocos2dxActivity activity = (Cocos2dxActivity) Cocos2dxActivity.getContext();
        activity.runOnGLThread(() -> Cocos2dxJavascriptJavaBridge.evalString("cc.onXSDKCallBack('" + script.replace("\"", "\\\"") + "')"));

    }
    //================================================================================

    // 初使化sdk
    static public void initSDK(String jsonStr) {
        if (isInitContext == false) {
            XSDK.getInstance().init(Cocos2dxActivity.getContext());
            isInitContext = true;
        }

        int callBackId = 0;
        String params = "";
        try {
            JSONObject j = new JSONObject(jsonStr);
            callBackId = j.getInt("callBackId");
            params = j.getString("params");
        } catch (JSONException e) {
            e.printStackTrace();
        }

        int finalCallBackId = callBackId;
        XSDK.initSDK(params, new IXSDKCallback() {
            @Override
            public void onSuccess(String ret) {
                try {
                    JSONObject j = new JSONObject();
                    j.put("callBackId", finalCallBackId);
                    j.put("method", "onSuccess");
                    j.put("ret", ret);
                    runScript(j.toString());
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onFaild(String ret) {
                try {
                    JSONObject j = new JSONObject();
                    j.put("callBackId", finalCallBackId);
                    j.put("method", "onFaild");
                    j.put("ret", ret);
                    runScript(j.toString());
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    // 分享
    static public void share(String jsonStr) {
        if (isInitContext == false) {
            return;
        }

        int callBackId = 0;
        String params = "";
        try {
            JSONObject j = new JSONObject(jsonStr);
            callBackId = j.getInt("callBackId");
            params = j.getString("params");
        } catch (JSONException e) {
            e.printStackTrace();
        }

        int finalCallBackId = callBackId;
        XSDK.share(params, new IXSDKCallback() {
            @Override
            public void onSuccess(String ret) {
                try {
                    JSONObject j = new JSONObject();
                    j.put("callBackId", finalCallBackId);
                    j.put("method", "onSuccess");
                    j.put("ret", ret);
                    runScript(j.toString());
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onFaild(String ret) {
                try {
                    JSONObject j = new JSONObject();
                    j.put("callBackId", finalCallBackId);
                    j.put("method", "onFaild");
                    j.put("ret", ret);
                    runScript(j.toString());
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    // 支付
    static public void pay(String jsonStr) {
        if (isInitContext == false) {
            return;
        }

        int callBackId = 0;
        String params = "";
        try {
            JSONObject j = new JSONObject(jsonStr);
            callBackId = j.getInt("callBackId");
            params = j.getString("params");
        } catch (JSONException e) {
            e.printStackTrace();
        }

        int finalCallBackId = callBackId;
        XSDK.pay(params, new IXSDKCallback() {
            @Override
            public void onSuccess(String ret) {
                try {
                    JSONObject j = new JSONObject();
                    j.put("callBackId", finalCallBackId);
                    j.put("method", "onSuccess");
                    j.put("ret", ret);
                    runScript(j.toString());
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onFaild(String ret) {
                try {
                    JSONObject j = new JSONObject();
                    j.put("callBackId", finalCallBackId);
                    j.put("method", "onFaild");
                    j.put("ret", ret);
                    runScript(j.toString());
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    // 登陆
    static public void login(String jsonStr) {
        if (isInitContext == false) {
            return;
        }

        int callBackId = 0;
        String params = "";
        try {
            JSONObject j = new JSONObject(jsonStr);
            callBackId = j.getInt("callBackId");
            params = j.getString("params");
        } catch (JSONException e) {
            e.printStackTrace();
        }

        int finalCallBackId = callBackId;
        XSDK.login(params, new IXSDKCallback() {
            @Override
            public void onSuccess(String ret) {
                try {
                    JSONObject j = new JSONObject();
                    j.put("callBackId", finalCallBackId);
                    j.put("method", "onSuccess");
                    j.put("ret", ret);
                    runScript(j.toString());
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onFaild(String ret) {
                try {
                    JSONObject j = new JSONObject();
                    j.put("callBackId", finalCallBackId);
                    j.put("method", "onFaild");
                    j.put("ret", ret);
                    runScript(j.toString());
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    // 登出
    static public void logout(String jsonStr) {
        if (isInitContext == false) {
            return;
        }

        int callBackId = 0;
        String params = "";
        try {
            JSONObject j = new JSONObject(jsonStr);
            callBackId = j.getInt("callBackId");
            params = j.getString("params");
        } catch (JSONException e) {
            e.printStackTrace();
        }

        int finalCallBackId = callBackId;
        XSDK.logout(params, new IXSDKCallback() {
            @Override
            public void onSuccess(String ret) {
                try {
                    JSONObject j = new JSONObject();
                    j.put("callBackId", finalCallBackId);
                    j.put("method", "onSuccess");
                    j.put("ret", ret);
                    runScript(j.toString());
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onFaild(String ret) {
                try {
                    JSONObject j = new JSONObject();
                    j.put("callBackId", finalCallBackId);
                    j.put("method", "onFaild");
                    j.put("ret", ret);
                    runScript(j.toString());
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    // 上交事件
    static void postEvent(String jsonStr) {
        if (isInitContext == false) {
            return;
        }
        XSDK.postEvent(jsonStr);
    }

    // 监听推送
    static void onPush(String jsonStr) {
        if (isInitContext == false) {
            return;
        }

        int callBackId = 0;
        String params = "";
        try {
            JSONObject j = new JSONObject(jsonStr);
            callBackId = j.getInt("callBackId");
            params = j.getString("params");
        } catch (JSONException e) {
            e.printStackTrace();
        }

        int finalCallBackId = callBackId;
        XSDK.onPush(new IPushCallback() {
            @Override
            public void onRegisterSucceed(String ret) {
                try {
                    JSONObject j = new JSONObject();
                    j.put("callBackId", finalCallBackId);
                    j.put("method", "onRegisterSucceed");
                    j.put("ret", ret);
                    runScript(j.toString());
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onNotificationMessageClicked(String ret) {
                try {
                    JSONObject j = new JSONObject();
                    j.put("callBackId", finalCallBackId);
                    j.put("method", "onNotificationMessageClicked");
                    j.put("ret", ret);
                    runScript(j.toString());
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onNotificationMessageArrived(String ret) {
                try {
                    JSONObject j = new JSONObject();
                    j.put("callBackId", finalCallBackId);
                    j.put("method", "onNotificationMessageArrived");
                    j.put("ret", ret);
                    runScript(j.toString());
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    //======================================================================================
    static public int createBannerAd(String jsonStr) {
        if (isInitContext == false) {
            return 0;
        }

        int callBackId = 0;
        String params = "";
        try {
            JSONObject j = new JSONObject(jsonStr);
            callBackId = j.getInt("callBackId");
            params = j.getString("params");
        } catch (JSONException e) {
            e.printStackTrace();
        }

        int finalCallBackId = callBackId;

        IBannerAd ad = XSDK.createBannerAd(params, new IBannerAdEventCallBack() {
            @Override
            public void onLoad(String ret) {

                try {
                    JSONObject j = new JSONObject();
                    j.put("callBackId", finalCallBackId);
                    j.put("method", "onLoad");
                    j.put("ret", ret);
                    runScript(j.toString());
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onHide() {
                try {
                    JSONObject j = new JSONObject();
                    j.put("callBackId", finalCallBackId);
                    j.put("method", "onHide");
                    runScript(j.toString());
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onError(String ret) {
                try {
                    JSONObject j = new JSONObject();
                    j.put("callBackId", finalCallBackId);
                    j.put("method", "onError");
                    j.put("ret", ret);
                    runScript(j.toString());
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

        //=============================================
        int key = getObjectKey();
        setObjectByKey(key, ad);
        return key;
        //=============================================
    }

    static public void showBannerAd(String jsonStr) {
        int objectId = 0;
        String params = "";
        try {
            JSONObject j = new JSONObject(jsonStr);
            objectId = j.getInt("objectId");
            params = j.getString("params");
        } catch (JSONException e) {
            e.printStackTrace();
        }
        IBannerAd ad = (IBannerAd) getObjectByKey(objectId);
        ad.show(params);
    }

    static public void hideBannerAd(String jsonStr) {
        int objectId = 0;
        try {
            JSONObject j = new JSONObject(jsonStr);
            objectId = j.getInt("objectId");
        } catch (JSONException e) {
            e.printStackTrace();
        }
        IBannerAd ad = (IBannerAd) getObjectByKey(objectId);
        ad.hide();
    }

    static public void destoryBannerAd(String jsonStr) {
        int objectId = 0;
        try {
            JSONObject j = new JSONObject(jsonStr);
            objectId = j.getInt("objectId");
        } catch (JSONException e) {
            e.printStackTrace();
        }
        IBannerAd ad = (IBannerAd) getObjectByKey(objectId);
        ad.destory();
        removeObjectByKey(objectId);
    }

    //======================================================================================
    static public int createRewardedVideoAd(String jsonStr) {
        if (isInitContext == false) {
            return 0;
        }

        int callBackId = 0;
        String params = "";
        try {
            JSONObject j = new JSONObject(jsonStr);
            callBackId = j.getInt("callBackId");
            params = j.getString("params");
        } catch (JSONException e) {
            e.printStackTrace();
        }

        int finalCallBackId = callBackId;

        IRewardedVideoAd ad = XSDK.createRewardedVideoAd(params, new IRewardedVideoAdEventCallBack() {
            @Override
            public void onError(String ret) {
                try {
                    JSONObject j = new JSONObject();
                    j.put("callBackId", finalCallBackId);
                    j.put("method", "onError");
                    j.put("ret", ret);
                    runScript(j.toString());
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onLoad(String ret) {
                try {
                    JSONObject j = new JSONObject();
                    j.put("callBackId", finalCallBackId);
                    j.put("method", "onLoad");
                    j.put("ret", ret);
                    runScript(j.toString());
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onReward() {
                try {
                    JSONObject j = new JSONObject();
                    j.put("callBackId", finalCallBackId);
                    j.put("method", "onReward");
                    runScript(j.toString());
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onClose() {
                try {
                    JSONObject j = new JSONObject();
                    j.put("callBackId", finalCallBackId);
                    j.put("method", "onClose");
                    runScript(j.toString());
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

        //=============================================
        int key = getObjectKey();
        setObjectByKey(key, ad);
        return key;
        //=============================================
    }

    static public void showRewardedVideoAd(String jsonStr) {
        int objectId = 0;
        try {
            JSONObject j = new JSONObject(jsonStr);
            objectId = j.getInt("objectId");
        } catch (JSONException e) {
            e.printStackTrace();
        }
        IRewardedVideoAd ad = (IRewardedVideoAd) getObjectByKey(objectId);
        ad.show();
    }

    static public void destoryRewardedVideoAd(String jsonStr) {
        int objectId = 0;
        try {
            JSONObject j = new JSONObject(jsonStr);
            objectId = j.getInt("objectId");
        } catch (JSONException e) {
            e.printStackTrace();
        }
        IRewardedVideoAd ad = (IRewardedVideoAd) getObjectByKey(objectId);
        ad.destory();
        removeObjectByKey(objectId);
    }

    //======================================================================================
    static public int createNativeAd(String jsonStr) {
        if (isInitContext == false) {
            return 0;
        }

        int callBackId = 0;
        String params = "";
        try {
            JSONObject j = new JSONObject(jsonStr);
            callBackId = j.getInt("callBackId");
            params = j.getString("params");
        } catch (JSONException e) {
            e.printStackTrace();
        }

        int finalCallBackId = callBackId;

        INativeAd ad = XSDK.createNativeAd(params, new INativeAdEventCallBack() {
            @Override
            public void onError(String ret) {
                try {
                    JSONObject j = new JSONObject();
                    j.put("callBackId", finalCallBackId);
                    j.put("method", "onError");
                    j.put("ret", ret);
                    runScript(j.toString());
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onLoad(String ret) {
                try {
                    JSONObject j = new JSONObject();
                    j.put("callBackId", finalCallBackId);
                    j.put("method", "onLoad");
                    j.put("ret", ret);
                    runScript(j.toString());
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onClick() {
                try {
                    JSONObject j = new JSONObject();
                    j.put("callBackId", finalCallBackId);
                    j.put("method", "onClick");

                    runScript(j.toString());
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

        //=============================================
        int key = getObjectKey();
        setObjectByKey(key, ad);
        return key;
        //=============================================
    }

    static public void reportNativeAdShow(String jsonStr) {
        int objectId = 0;
        try {
            JSONObject j = new JSONObject(jsonStr);
            objectId = j.getInt("objectId");
        } catch (JSONException e) {
            e.printStackTrace();
        }
        INativeAd ad = (INativeAd) getObjectByKey(objectId);
        ad.reportAdShow();
    }


    static public void reportNativeAdClick(String jsonStr) {
        int objectId = 0;
        String adName = "";
        try {
            JSONObject j = new JSONObject(jsonStr);
            objectId = j.getInt("objectId");
            adName = j.getString("adName");
        } catch (JSONException e) {
            e.printStackTrace();
        }
        INativeAd ad = (INativeAd) getObjectByKey(objectId);
        ad.reportAdClick(adName);
    }

    static public void destoryNativeAd(String jsonStr) {
        int objectId = 0;
        try {
            JSONObject j = new JSONObject(jsonStr);
            objectId = j.getInt("objectId");
        } catch (JSONException e) {
            e.printStackTrace();
        }
        INativeAd ad = (INativeAd) getObjectByKey(objectId);
        ad.destory();
        removeObjectByKey(objectId);
    }

    //======================================================================================
}
