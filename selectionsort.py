  
numbers = list(map(int, input().split()))
for i in range(len(numbers)-1):
  min_number = numbers[i]
  for j in range(i,len(numbers)-1):
    if min_number > numbers[j+1]:
      min_number = numbers[j+1]
    k = numbers.index(min_number)
  numbers[i],numbers[k] = numbers[k],numbers[i]    
print(numbers)
