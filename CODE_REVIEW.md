# Code Review

### 1. Network request in ViewModel

**Problem:**  
The ViewModel directly performs the network request.

**Fix:**  
Move the network operation to the Repository/data layer.

### 2. Blocking operation

**Problem:**  
`readText()` performs synchronous I/O and can block the main thread.

**Fix:**  
Use coroutines and perform the operation on an I/O dispatcher.

### 3. No error handling

**Problem:**  
Network and parsing errors are not handled.

**Fix:**  
Fix: Handle errors in the data layer and expose the result to the ViewModel. Alternatively, errors can be handled directly in the ViewModel for simpler cases.
### 4. Mutable state

**Problem:**  
`movies` is publicly mutable.

**Fix:**  
Expose an immutable state to the UI and keep the mutable state private inside the ViewModel.
### 5. Hardcoded URL

**Problem:**  
The API URL is hardcoded in the ViewModel.

**Fix:**  
Move the API endpoint to the data layer and use an API service such as Retrofit.