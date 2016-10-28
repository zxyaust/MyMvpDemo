# MyMvpDemo
##模拟网络请求和数据库操作,基本可以胜任一切操作,
#总结:
###1.每个界面,需要四个文件,view,model,presenter,contract
###2.view只负责界面处理,点击滑动等界面交互
###3.model负责数据的存取修改等,包括网络数据,如果异步操作,contract中需要添加网络返回的listener接口
###4.presenter业务层,负责model和view的连同,view和model原则上不允许直接交互,否则比较乱,直接响应view发出的命令,然后传送给model去处理,获取到数据之后model返回数据给presenter层(同步直接return,异步使用contract的Listener通知presenter层并为其返回数据)
###5.contract里面是使用的全部需要的接口,view,model,presenter的父类接口,规定出子类必须实现的东西,如果是异步方法,里面还需要一个listener,用来异步返回给presenter层,然后在让presenter层把数据传递给view层
#总结2:
###1.view中创建presenter对象,用来向P层发送命令
###2.presenter层需要用构造方法获得view的实例,同时要创建一个model的实例,他要联通VM两层,所以要把两层的对象都持有,presenter可以主动向v和m通信,所以持有他们两个对象
###3.在同步操作中presenter主动与Model通信,不需要Model持有presenter对象
###4.但是异步操作时,Model也需要主动通知p层,而不适合持有presenter对象,所以只能Model中持有一个listener对象,用于通知p层所得的结果,
一般同步对应数据库读取,本地获取数据,等等不算太耗时的操作
异步对应于网络请求
**同一个页面上有多个view需要查询数据库,请求网络,都可以放入同一套mvp中,分成不同的任务即可**
