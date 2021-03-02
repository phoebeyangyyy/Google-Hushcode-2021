# Google-Hushcode-2021

**Traffic signaling**

Google hashcode 2021 submission Total score - 7, 168, 575

**Team: Knives out**
Keyan Chen
Tianyu Zhan
Jia Shi
Yuyao Yang

**Solution**

截取第一行input 确定总时间 ，路口，街道，车辆数量和得分

根据截取的数量 遍历截取后续行并对应放入车辆obj，街道obj

初始车辆的起始点 放入起始街道的queue，while totaltime<=总时间 total_time +=1，对比同一个路口的所有queue的长度，

将最长的pop，该路口绿灯时长加一， 同时判断所有pop出来的车要走的下一个街道，if car.streetname = street.name: car.time = street.time_pass

while globaltime +1: car.time -1. if car.time = 0,streename = stree.name push car in street.queue

while totaltime >总时间, break<img width="942" alt="Screen Shot 2021-02-28 at 10 04 53 PM" src="https://user-
