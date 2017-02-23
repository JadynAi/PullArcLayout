# PullArcLayout
### 简介
 下拉可以随手指移动距离改变弧度的布局
#### 先看看效果吧
 ![看我看我看我！](https://github.com/JadynAi/PullArcLayout/blob/master/app/GIF.gif)
### 思路如下
  这个效果的最初始是因为项目中的需求效果，写完之后觉得还不错。就把思路整理了一下，顺便记录一下自己的想法。
  
  ---
  原项目中使用的下拉框架在这里就不在做展示，而使用YListview做替代。其实讲内部原理的话都是差不多的，就是在下拉的过程中，顶部的View不停调用setLayoutParams方法，从而使布局的高度不断改变。
  而setLayoutParams方法的内部则会调用requestLayout方法，view的绘制流程如下：
  ![]()
  
### Path
 - rewind（）方法和reset（）方法的区别

> reset清除path上的内容，重置path到 path = new Path()的初始状态。<br>
    rewind清除path上的内容，但会保留path上相关的数据结构，以高效的复用。

### 感谢以下开源项目：
 - [YListView](https://github.com/yll2wcf/YLListView)
