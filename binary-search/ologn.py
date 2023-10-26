import time

def binary_search(arr, target):
    low, high = 0, len(arr) - 1
    while low <= high:
        mid = (low + high) // 2
        if arr[mid] == target:
            return mid
        elif arr[mid] < target:
            low = mid + 1
        else:
            high = mid - 1
    return -1

arr = list(range(1, 100000000))  # Generating a sorted list of numbers from 1 to 99999999
target = 999999

start_time = time.time()
index = binary_search(arr, target)
end_time = time.time()
elapsed_time = end_time - start_time

if index != -1:
    print(f"Found {target} at index {index} in {elapsed_time} seconds.")
else:
    print(f"{target} not found in the list using O log n.")
