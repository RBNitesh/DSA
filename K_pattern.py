n=int(input("Enter the no. of columns:"))
for i in range (0,n-1):
    for j in range (0,n):
        if j==0 or j==(n-1)-i:
            print("*",end="")
        else:
            print(" ",end="")
    print()
for i in range (n-1,(n*2)-3):
    for j in range (0,n):
        if j==0 or j==i-n+2:
            print("*", end="")
        else:
            print(" ",end="")
    print()
    


        