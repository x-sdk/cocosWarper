import XSDK from './xsdk';

const { ccclass, property } = cc._decorator;

@ccclass
export default class NewClass extends cc.Component {
  @property(cc.Node)
  initButton: cc.Node = null;

  @property(cc.Node)
  bannerButton: cc.Node = null;

  @property(cc.Node)
  closeBannerButton: cc.Node = null;

  @property(cc.Node)
  showBannerButton: cc.Node = null;

  @property(cc.Node)
  destoryBannerButton: cc.Node = null;

  @property(cc.Node)
  videoButton: cc.Node = null;

  @property(cc.Node)
  NativeADButton:cc.Node = null

  bannerObjId = 0;
  videAwardObjId = 0;
  // LIFE-CYCLE CALLBACKS:

  onLoad() {
    this.initButton.on(cc.Node.EventType.TOUCH_START, this.initSDK, this);
    this.bannerButton.on(cc.Node.EventType.TOUCH_START, this.initBanner, this);

    this.closeBannerButton.on(
      cc.Node.EventType.TOUCH_START,
      () => {
        this.bannerObjId != 0 && XSDK.hideBannerAd(this.bannerObjId);
      },
      this
    );

    this.showBannerButton.on(
      cc.Node.EventType.TOUCH_START,
      () => {
        this.bannerObjId != 0 && XSDK.showBannerAd(this.bannerObjId);
      },
      this
    );

    this.destoryBannerButton.on(
      cc.Node.EventType.TOUCH_START,
      () => {
        this.bannerObjId != 0 && XSDK.destoryBannerAd(this.bannerObjId);
        this.bannerObjId = 0;
      },
      this
    );

    this.videoButton.on(
      cc.Node.EventType.TOUCH_START,
      () => {
        this.videAwardObjId = XSDK.createRewardedVideoAd(
          {
            provider: 'admob',
            adUnitId: 'ca-app-pub-3940256099942544/5224354917',
          },
          {
            onError: (ret) => {
              console.log('videoAward', 'onError');
            },
            onLoad:(ret) => {
              console.log('videoAward', 'onLoad');
              XSDK.showRewardedVideoAd(this.videAwardObjId)
            },
            onReward:()=>{
              console.log('videoAward', 'onReward');
            },
            onClose:()=>{
              console.log('videoAward', 'onClose');
              XSDK.destoryRewardedVideoAd(this.videAwardObjId)
            },
          }
        );
      },
      this
    );

    this.NativeADButton.on(cc.Node.EventType.TOUCH_START,
      () => {
        XSDK.createNativeAd(
        {
          provider: 'admob',
          adUnitId: 'ca-app-pub-3940256099942544/2247696110',
        },
        {
          onLoad:(ret) => {
            console.log( 'onLoad', ret);
          },
          onClick:()=>{
            console.log('onClick');
          },
          onError:(ret)=>{
            console.log('onError', ret);
          },
        }
      );
    },
    this);


  }

  start() {}

  initSDK() {
    XSDK.initSDK(
      {
        provider: 'admob',
        service: 'ad',
      },
      {
        onSuccess: (ret) => {
          console.log('onSuccess', ret);
        },
        onFaild: (ret) => {
          console.log('onFaild', ret);
        },
      }
    );
  }

  initBanner() {
    this.bannerObjId = XSDK.createBannerAd(
      {
        provider: 'admob',
        adUnitId: 'ca-app-pub-3940256099942544/6300978111',
      },
      {
        onError: (ret) => {
          console.log('onError', ret);
        },
        onLoad: (ret) => {
          console.log('onLoad', ret);
          XSDK.showBannerAd(this.bannerObjId, {});
        },
        onReward: (ret) => {
          console.log('onReward', ret);
        },
        onClose: (ret) => {
          console.log('onClose', ret);
        },
      }
    );
  }

  // update (dt) {}
}
