# PullArcLayout
### 简介
 下拉可以随手指移动距离改变弧度的布局——ArcContainer
#### 先看看效果吧
 ![看我看我看我！](https://github.com/JadynAi/PullArcLayout/blob/master/app/GIF.gif)
### 思路如下
  这个效果的最初始是因为项目中的需求效果，写完之后觉得还不错。就把思路整理了一下，顺便记录一下自己的想法。
  
  ---
  - 原项目中使用的下拉框架在这里就不在做展示，而使用YListview做替代。其实讲内部原理的话都是差不多的，就是在下拉的过程中，顶部的View不停调用setLayoutParams方法，从而使布局的高度不断改变。<br>而setLayoutParams方法的内部则会调用requestLayout方法，从而让View不断的重新绘制。
  - 使用Canvas在下拉过程中不断的绘制出特定的Path，以及Paint的setXfermode（）方法提供的混合模式。
  - 还有一个知识点：
   - 自定义View，时一般重写的话会选择onDraw（）方法。而ViewGroup容器组件的绘制，当它没有背景时直接调用的是dispatchDraw()方法, 而绕过了draw()方法，当它有背景的时候就调用draw()方法，而draw()方法里包含了dispatchDraw()方法的调用。因此要在ViewGroup上绘制东西的时候往往重写的是dispatchDraw()方法而不是onDraw()方法。

#### 1.先把需要的对象创建出来，尤其注意Xfermode的模式选择
  `porterDuffXfermode = new PorterDuffXfermode(PorterDuff.Mode.CLEAR);`
        mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        mPaint.setColor(Color.WHITE);
       mClipPath = new Path();`
       
#### 2.在onMeasure（）方法里，绘制Path路径
   - 基本样子是介个样子的，如图中橘色线框起来的部分：<br>
   ![路径如图](https://github.com/JadynAi/PullArcLayout/blob/master/app/20170223175153.png)
 
  
### Path
 - rewind（）方法和reset（）方法的区别

> reset清除path上的内容，重置path到 path = new Path()的初始状态。<br>
    rewind清除path上的内容，但会保留path上相关的数据结构，以高效的复用。

### 感谢以下开源项目：
 - [YListView](https://github.com/yll2wcf/YLListView)
