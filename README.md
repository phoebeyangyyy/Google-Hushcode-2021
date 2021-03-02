# HashCode2021
## 算法
截取第一行input 确定总时间 ，路口，街道，车辆数量和得分

根据截取的数量 遍历截取后续行并对应放入车辆obj，街道obj

初始车辆的起始点 放入起始街道的queue，while totaltime<=总时间 total_time +=1，对比同一个路口的所有queue的长度，

将最长的pop，该路口绿灯时长加一， 同时判断所有pop出来的车要走的下一个街道，if car.streetname = street.name: car.time = street.time_pass

while globaltime +1: car.time -1. if car.time = 0,streename = stree.name push car in street.queue

while totaltime >总时间, break