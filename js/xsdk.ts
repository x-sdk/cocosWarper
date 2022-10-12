//==================================================================
let callBackMap = new Map();

// @ts-ignore
if (cc.onXSDKCallBack == null) {
  // @ts-ignore
  cc.onXSDKCallBack = (ret: string) => {
    let retObj = JSON.parse(ret);
    if (retObj.method) {
      let callBack = callBackMap.get(retObj.callBackId);
      if (callBack[retObj.method]) {
        if (retObj.ret) {
          callBack[retObj.method](JSON.parse(retObj.ret));
        } else {
          callBack[retObj.method]();
        }
      }
    }
  };
}

let callBackId = 0;
function getCallBackId(): number {
  callBackId += 1;
  return callBackId;
}

let callBackObjMap = new Map();
//==================================================================

class XSDK {
  public static clearCallBack(callBackId: number) {
    callBackMap.delete(callBackId);
  }

  public static initSDK(params: object, callBack) {
    let callBackId = getCallBackId();
    let jsonObj = {
      callBackId: callBackId,
      params: JSON.stringify(params),
    };
    callBackMap.set(callBackId, callBack);
    if (cc.sys.isNative && cc.sys.OS_ANDROID === cc.sys.os) {
      jsb.reflection.callStaticMethod('org/cocos2dx/xsdk/XSDKCocosWarper', 'initSDK', '(Ljava/lang/String;)V', JSON.stringify(jsonObj));
    } else if (cc.sys.isNative && cc.sys.OS_IOS === cc.sys.os) {
    }
    return callBackId;
  }

  public static pay(params: object, callBack) {
    let callBackId = getCallBackId();
    let jsonObj = {
      callBackId: callBackId,
      params: JSON.stringify(params),
    };
    callBackMap.set(callBackId, callBack);
    if (cc.sys.isNative && cc.sys.OS_ANDROID === cc.sys.os) {
      jsb.reflection.callStaticMethod('org/cocos2dx/xsdk/XSDKCocosWarper', 'pay', '(Ljava/lang/String;)V', JSON.stringify(jsonObj));
    } else if (cc.sys.isNative && cc.sys.OS_IOS === cc.sys.os) {
    }
    return callBackId;
  }

  public static login(params: object, callBack) {
    let callBackId = getCallBackId();
    let jsonObj = {
      callBackId: callBackId,
      params: JSON.stringify(params),
    };
    callBackMap.set(callBackId, callBack);
    if (cc.sys.isNative && cc.sys.OS_ANDROID === cc.sys.os) {
      jsb.reflection.callStaticMethod('org/cocos2dx/xsdk/XSDKCocosWarper', 'login', '(Ljava/lang/String;)V', JSON.stringify(jsonObj));
    } else if (cc.sys.isNative && cc.sys.OS_IOS === cc.sys.os) {
    }
    return callBackId;
  }

  public static logout(params: object, callBack) {
    let callBackId = getCallBackId();
    let jsonObj = {
      callBackId: callBackId,
      params: JSON.stringify(params),
    };
    callBackMap.set(callBackId, callBack);
    if (cc.sys.isNative && cc.sys.OS_ANDROID === cc.sys.os) {
      jsb.reflection.callStaticMethod('org/cocos2dx/xsdk/XSDKCocosWarper', 'logout', '(Ljava/lang/String;)V', JSON.stringify(jsonObj));
    } else if (cc.sys.isNative && cc.sys.OS_IOS === cc.sys.os) {
    }
    return callBackId;
  }

  public static share(params: object, callBack) {
    let callBackId = getCallBackId();
    let jsonObj = {
      callBackId: callBackId,
      params: JSON.stringify(params),
    };
    callBackMap.set(callBackId, callBack);
    if (cc.sys.isNative && cc.sys.OS_ANDROID === cc.sys.os) {
      jsb.reflection.callStaticMethod('org/cocos2dx/xsdk/XSDKCocosWarper', 'share', '(Ljava/lang/String;)V', JSON.stringify(jsonObj));
    } else if (cc.sys.isNative && cc.sys.OS_IOS === cc.sys.os) {
    }
    return callBackId;
  }

  public static postEvent(params: object) {
    if (cc.sys.isNative && cc.sys.OS_ANDROID === cc.sys.os) {
      jsb.reflection.callStaticMethod('org/cocos2dx/xsdk/XSDKCocosWarper', 'postEvent', '(Ljava/lang/String;)V', JSON.stringify(params));
    } else if (cc.sys.isNative && cc.sys.OS_IOS === cc.sys.os) {
    }
  }

  //================================================================================================================================
  public static createBannerAd(params: object, callBack): number {
    let callBackId = getCallBackId();
    let jsonObj = {
      callBackId: callBackId,
      params: JSON.stringify(params),
    };
    callBackMap.set(callBackId, callBack);
    let ret: number = 0;
    if (cc.sys.isNative && cc.sys.OS_ANDROID === cc.sys.os) {
      ret = jsb.reflection.callStaticMethod('org/cocos2dx/xsdk/XSDKCocosWarper', 'createBannerAd', '(Ljava/lang/String;)I', JSON.stringify(jsonObj));
    } else if (cc.sys.isNative && cc.sys.OS_IOS === cc.sys.os) {
    }
    callBackObjMap.set(ret, callBackId);
    return ret;
  }

  public static showBannerAd(objectId: number, params: object = {}) {
    let jsonObj = {
      objectId: objectId,
      params: JSON.stringify(params),
    };
    if (cc.sys.isNative && cc.sys.OS_ANDROID === cc.sys.os) {
      jsb.reflection.callStaticMethod('org/cocos2dx/xsdk/XSDKCocosWarper', 'showBannerAd', '(Ljava/lang/String;)V', JSON.stringify(jsonObj));
    } else if (cc.sys.isNative && cc.sys.OS_IOS === cc.sys.os) {
    }
  }

  public static hideBannerAd(objectId: number) {
    let jsonObj = {
      objectId: objectId,
    };

    if (cc.sys.isNative && cc.sys.OS_ANDROID === cc.sys.os) {
      jsb.reflection.callStaticMethod('org/cocos2dx/xsdk/XSDKCocosWarper', 'hideBannerAd', '(Ljava/lang/String;)V', JSON.stringify(jsonObj));
    } else if (cc.sys.isNative && cc.sys.OS_IOS === cc.sys.os) {
    }
  }

  public static destoryBannerAd(objectId: number) {
    let jsonObj = {
      objectId: objectId,
    };

    if (cc.sys.isNative && cc.sys.OS_ANDROID === cc.sys.os) {
      jsb.reflection.callStaticMethod('org/cocos2dx/xsdk/XSDKCocosWarper', 'destoryBannerAd', '(Ljava/lang/String;)V', JSON.stringify(jsonObj));
    } else if (cc.sys.isNative && cc.sys.OS_IOS === cc.sys.os) {
    }

    let callBackId = callBackObjMap.get(objectId);
    callBackMap.delete(callBackId);
    callBackObjMap.delete(callBackId);
  }

  //================================================================================================================================
  public static createRewardedVideoAd(params: object, callBack): number {
    let callBackId = getCallBackId();
    let jsonObj = {
      callBackId: callBackId,
      params: JSON.stringify(params),
    };
    callBackMap.set(callBackId, callBack);
    let ret: number = 0;
    if (cc.sys.isNative && cc.sys.OS_ANDROID === cc.sys.os) {
      ret = jsb.reflection.callStaticMethod('org/cocos2dx/xsdk/XSDKCocosWarper', 'createRewardedVideoAd', '(Ljava/lang/String;)I', JSON.stringify(jsonObj));
    } else if (cc.sys.isNative && cc.sys.OS_IOS === cc.sys.os) {
    }
    callBackObjMap.set(ret, callBackId);
    return ret;
  }

  public static showRewardedVideoAd(objectId: number) {
    let jsonObj = {
      objectId: objectId,
    };
    if (cc.sys.isNative && cc.sys.OS_ANDROID === cc.sys.os) {
      jsb.reflection.callStaticMethod('org/cocos2dx/xsdk/XSDKCocosWarper', 'showRewardedVideoAd', '(Ljava/lang/String;)V', JSON.stringify(jsonObj));
    } else if (cc.sys.isNative && cc.sys.OS_IOS === cc.sys.os) {
    }
  }

  public static destoryRewardedVideoAd(objectId: number) {
    let jsonObj = {
      objectId: objectId,
    };
    if (cc.sys.isNative && cc.sys.OS_ANDROID === cc.sys.os) {
      jsb.reflection.callStaticMethod('org/cocos2dx/xsdk/XSDKCocosWarper', 'destoryRewardedVideoAd', '(Ljava/lang/String;)V', JSON.stringify(jsonObj));
    } else if (cc.sys.isNative && cc.sys.OS_IOS === cc.sys.os) {
    }
    // 清除缓存
    let callBackId = callBackObjMap.get(objectId);
    callBackMap.delete(callBackId);
    callBackObjMap.delete(callBackId);
  }

  //================================================================================================================================
  public static createNativeAd(params: object, callBack): number {
    let callBackId = getCallBackId();
    let jsonObj = {
      callBackId: callBackId,
      params: JSON.stringify(params),
    };
    callBackMap.set(callBackId, callBack);
    let ret: number = 0;
    if (cc.sys.isNative && cc.sys.OS_ANDROID === cc.sys.os) {
      ret = jsb.reflection.callStaticMethod('org/cocos2dx/xsdk/XSDKCocosWarper', 'createNativeAd', '(Ljava/lang/String;)I', JSON.stringify(jsonObj));
    } else if (cc.sys.isNative && cc.sys.OS_IOS === cc.sys.os) {
    }
    callBackObjMap.set(ret, callBackId);
    return ret;
  }

  public static reportNativeAdShow(objectId: number) {
    let jsonObj = {
      objectId: objectId,
    };
    if (cc.sys.isNative && cc.sys.OS_ANDROID === cc.sys.os) {
      jsb.reflection.callStaticMethod('org/cocos2dx/xsdk/XSDKCocosWarper', 'reportNativeAdShow', '(Ljava/lang/String;)V', JSON.stringify(jsonObj));
    } else if (cc.sys.isNative && cc.sys.OS_IOS === cc.sys.os) {
    }
  }

  public static reportNativeAdClick(objectId: number, adName: string) {
    let jsonObj = {
      objectId: objectId,
    };
    if (cc.sys.isNative && cc.sys.OS_ANDROID === cc.sys.os) {
      jsb.reflection.callStaticMethod('org/cocos2dx/xsdk/XSDKCocosWarper', 'reportNativeAdClick', '(Ljava/lang/String;)V', JSON.stringify(jsonObj));
    } else if (cc.sys.isNative && cc.sys.OS_IOS === cc.sys.os) {
    }
  }

  public static destoryNativeAd(objectId: number) {
    let jsonObj = {
      objectId: objectId,
    };

    if (cc.sys.isNative && cc.sys.OS_ANDROID === cc.sys.os) {
      jsb.reflection.callStaticMethod('org/cocos2dx/xsdk/XSDKCocosWarper', 'destoryNativeAd', '(Ljava/lang/String;)V', JSON.stringify(jsonObj));
    } else if (cc.sys.isNative && cc.sys.OS_IOS === cc.sys.os) {
    }
    // 清除缓存
    let callBackId = callBackObjMap.get(objectId);
    callBackMap.delete(callBackId);
    callBackObjMap.delete(callBackId);
  }

  //================================================================================================================================
}

export default XSDK;
