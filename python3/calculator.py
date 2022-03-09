
try:
    firstInput = int(input('Enter First Number'))
    secondInput = int(input('Enter Second Number'))
    operator = input('Enter Operator')

    if operator == '+':
        print(firstInput+secondInput)
    elif operator == '-':
        print(firstInput-secondInput)
    elif operator == '*':
        print(firstInput*secondInput)
    elif operator == '/':
        print(abs(firstInput/secondInput))
except:
    print('Invalid input')
