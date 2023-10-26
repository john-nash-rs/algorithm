import time

def linear_search(arr, target):
    for i, element in enumerate(arr):
        if element == target:
            return i
    return -1

arr = list(range(1, 100000000))  # Generating a list of numbers from 1 to 99999999
target = 999999

start_time = time.time()
index = linear_search(arr, target)
end_time = time.time()
elapsed_time = end_time - start_time

if index != -1:
    print(f"Found {target} at index {index} in {elapsed_time} seconds.")
else:
    print(f"{target} not found in the list using O n.")
