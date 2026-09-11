## Entry 1: AGP and Gradle Version

### 1. What I asked the AI / the problem I was solving

I asked AI about the latest stable versions Android Gradle Plugin (AGP), and Gradle that could be used for my Android project. I wanted to update the project's build tools to newer versions.

### 2. What it gave me

The AI recommended newer versions of AGP and Gradle and explained the compatibility requirements between AGP, Gradle, and Android Studio.

### 3. What I did

I initially followed the recommendation and upgraded AGP and Gradle. However, after updating them, I found that the new AGP version required a newer Android Studio version than the one I was currently using.

Instead of upgrading Android Studio, I decided to keep my current Android Studio version and downgrade AGP and Gradle to versions compatible with it. I then verified the configuration by syncing and building the project successfully.

### 4. One thing the AI got wrong or that I verified myself

The latest AGP and Gradle versions were not automatically the best choice for my project because they were incompatible with my current Android Studio version. I verified the compatibility myself after the project failed to work with the newer versions. This led me to choose the AGP and Gradle versions based on my Android Studio version rather than simply using the latest versions.

## Entry 2: AppException

### 1. What I asked the AI / the problem I was solving

I asked AI to create an `AppException` to handle exceptions consistently and map errors based on their codes.

### 2. What it gave me

The AI suggested an `AppException` structure and a `safeCall` function for centralized exception handling.

### 3. What I did

I modified the `safeCall` implementation and used it in the Repository instead of the ViewModel, so data-layer exceptions are handled before reaching the presentation layer.

### 4. One thing the AI got wrong or that I verified myself

The initial `safeCall` usage did not fit my project architecture, so I moved it to the Repository layer.

## Entry 3: Date Formatter

### 1. What I asked the AI / the problem I was solving

I asked AI to create a date formatter for the application.

### 2. What it gave me

The AI suggested converting the date into a `Date` object in the domain layer.

### 3. What I did

I modified the approach to keep the date as a `String` in the domain model and only format it when needed for display.

### 4. One thing the AI got wrong or that I verified myself

I decided that converting it to a `Date` object was unnecessary for this use case because the application only needed to display the date.

## Entry 4: HTML Formatter

### 1. What I asked the AI / the problem I was solving

I asked AI to create an HTML formatter so HTML content such as bold text could be rendered correctly.

### 2. What it gave me

The AI suggested applying the HTML formatter in the mapper.

### 3. What I did

After explaining that my mapper only converts data from the data layer to the domain layer, I modified the approach and applied the formatter in the UI instead.

### 4. One thing the AI got wrong or that I verified myself

I verified that the formatter needed to render HTML styling such as bold text correctly. It was more appropriate to handle this in the UI because the formatting was only needed for displaying the content.

## Entry 5: Unit Test

### 1. What I asked the AI / the problem I was solving

I asked AI to create unit test examples for `getDetail`, covering both success and failure cases.

### 2. What it gave me

I recommended using Mockito. For test data, AI suggested using dummy `TVShowDetail` data instead of `mock<TVShowDetail>()`.

### 3. What I did

I chose to use dummy data because it represents realistic test input and makes the test easier to understand.

### 4. One thing the AI got wrong or that I verified myself

I verified that `TVShowDetail` did not need to be mocked because it is a data model, while Mockito was more appropriate for mocking the repository dependency.
