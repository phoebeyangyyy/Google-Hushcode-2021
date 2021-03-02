import collections.deque
class street(object):
    def __init__(self):
        self.intersaction_1 = 0
        self.intersaction_2 = 0
        self.street_name = ""
        self.time_pass = 0
        self.queue = []
class intersection():
    def __init__(self):
        self.ID = 0
        self.income = []
        self.output = []
#截取第一行input 确定总时间 ，路口，街道，车辆数量和得分
#根据截取的数量 遍历截取后续行并对应放入车辆obj，街道obj
#初始车辆的起始点 放入起始街道的queue，while totaltime<=总时间 total_time +=1，对比同一个路口的所有queue的长度，
#将最长的pop，该路口绿灯时长加一， 同时判断所有pop出来的车要走的下一个街道，if car.streetname = street.name: car.time = street.time_pass
#while globaltime +1: car.time -1. if car.time = 0,streename = stree.name push car in street.queue
#while totaltime >总时间, break

class lights():
    def __init__(self):
        red = True
        green = False
total_time = 0

class car():
    def __init__(self):
        self.time 
    # 5s  5s   4s   0s 
    #2s   a(2) b(3) c(4) d(5)
    #1s   a(2) b(3) a(2) b(3) c(4) d(5)
         

class schedule(intersection):
    def __init__(self):
        global total_time
        green_time = []


# simulate => 每一个street上的总的绿灯的时间 
    #     绿       车流
    # a:  10   1   10
    # b:  20   2   30
    # c:  30   3   40

# 一个intersection 按照street上的车流量 再分配
        
def process(fileName):

    # Print data to console
    print("")
    print("-----------------------")
    print(fileName)
    print("-----------------------")

    #  Read the open file by name
    inputFile = open(inputFilesDirectory + fileName + ".in", "rt")

    #  Read file
    firstLine = inputFile.readline()
    secondLine = inputFile.readline()
    inputFile.close()


    #  Print input data
    print("INPUT")
    print(firstLine)
    print(secondLine)

    #  Assign parameters
    MAX, NUM = list(map(int, firstLine.split()))

    #  Create the pizza list by reading the file
    inputList = list(map(int, secondLine.split()))

    #outputList = solve(MAX, inputList)  # Solve the problem and get output

    #  Print output data and create output file
       
    print("")
    print("OUTPUT")
    print(len(outputList))

    #outputString = ""
    #for l in outputList:
        #outputString = outputString + str(l) + " "
    #print(outputString)

    #outputFile = open(outputFilesDirectory + fileName + ".out", "w")
    #outputFile.write(str(len(outputList)) + "\n")
    #outputFile.write(outputString)
    #outputFile.close()


inputFilesDirectory = "Input/"  # Location of input files
outputFilesDirectory = "Output/"  # Location of output files

fileNames = ["a.txt"]  # File names

for fileName in fileNames:  # Take each and every file and solve
    process(fileName)

