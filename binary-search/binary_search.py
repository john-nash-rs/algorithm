def binary_search(arr, target):
    left, right = 0, len(arr) - 1

    while left <= right:
        mid = (left + right) // 2  # Calculate the middle index

        if arr[mid] == target:
            return mid  # Target found at index 'mid'
        elif arr[mid] < target:
            left = mid + 1  # Target is in the right half
        else:
            right = mid - 1  # Target is in the left half

    return -1  # Target not found in the array

# Example usage:
arr = [1, 3, 5, 7, 9, 11, 13, 15, 17, 19]
target = 13

index = binary_search(arr, target)

if index != -1:
    print(f"Found {target} at index {index}.")
else:
    print(f"{target} not found in the array.")
