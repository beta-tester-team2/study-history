def solution():
    
    pain=int(input())
    a,b = map(int,input().split(" "))
    pain2=pain
    
    count=0    
    count1=0
    count2=0
    
    #b나 a만으로 한번에 나눠지는지 확인 => b가 a의 배수인지도 확인해야 할 듯
    if (pain%b==0):
        count=pain//b
    elif (pain%a==0):
        count=pain//a
    else:
        #큰수인 b를 1번씩 빼보면서, 그때마다 남은 pain이 a로 한번에 나눠지는지 확인
        while (pain//b >= 1):
            pain=pain-b
            count1 += 1
            while (pain%a == 0): ##########여기가 어색함, 앞에 11-7=4되고나서
                count1=count1+pain//a
            if pain!=0:
                tmp=0
                count1=-1
            else:
                count=count1
                    
        print(pain, count1)        
        #여기까지 count1 값 그냥 떠다님
    

        while (pain2//a >= 1):
            pain2=pain2-a
            count2 += 1
            while (pain%b == 0): ##########여기가 어색함, 앞에 11-7=4되고나서
                count2=count2+pain//b
            if pain!=0:
                count2=-1
            else:
                count=count2
            print(pain2, count2)        

        if ((pain != 0)or(count1==0))and((pain2 != 0)or(count2==0)):
            count=-1
        elif count1>count2:
            count=count2
        elif count2>count1:
            count=count1

    print(count)

solution()