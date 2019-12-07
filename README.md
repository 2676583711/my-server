# my-server  



对于虚拟机，我们可能大部分都会选择使用命令行界面，但是对于我们的真实的机器，显然有图形界面在某些时候会更方便的。以下两种界面的转换是针对ubuntu18.04

一. 永久转换

1. 关闭用户图形界面

sudo systemctl set-default multi-user.target

sudo reboot

2. 开启用户图形界面

sudo systemctl set-default graphical.target

sudo reboot

一. 临时切换

切换到命令行界面,一般会默认打开6个命令行窗口，通过下面命令切换。

ctrl + Fn + alt + F(1-6)

切换到

作者：GoodUnity
链接：https://www.jianshu.com/p/b4343d3a6bcc
来源：简书
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
