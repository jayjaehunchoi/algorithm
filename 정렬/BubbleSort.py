numbers = list(map(int, input().split())) # 리스트 입력해주고
for i in range(1, len(numbers)): # 총 numbers-1 회 비교해줄거임!
  for j in range(0,len(numbers)-1): # 하지만 버블정렬은 순차적으로 변경되는 것이기때문에 항상 모든 수끼리 비교를해야함.
    if numbers[j] > numbers[j+1]:
      numbers[j], numbers[j+1] = numbers[j+1], numbers[j] # 매번 상대적으로 작은 값의 자리를 앞으로 이동.
print(numbers) # 모두 비교 후 프린트
