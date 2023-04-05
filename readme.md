
# Shimmer Animation Compose 
[![JitPack](https://jitpack.io/v/karvinok/shimmer-compose.svg)](https://jitpack.io/#karvinok/shimmer-compose)

A reusable and customizable Shimmer Animation composable built with Jetpack Compose.

## Usage

Add the following dependency to your project's `build.gradle` file:
```groovy  
allprojects {  
    repositories { 
    	 // ... 
    	 maven { url 'https://jitpack.io' }	 
    }
}  
  
dependencies {
 implementation 'com.github.karvinok:shimmer-compose:1.0.0'}  
 ...
}
```  

Then, simply use the `ShimmerAnimation` composable in your code:

```kotlin  
ShimmerAnimation(  
	modifier = Modifier,
	items = listOf(
		ShimmerItem.Circle(),
		ShimmerItem.Square(),
		ShimmerItem.Line(),
		ShimmerItem.Row(
			ShimmerItem.Square(),
			ShimmerItem.Spacer(),
			ShimmerItem.Line()
		)
), itemsPaddingDp = 16.dp)  
```  

## Customization

You can customize the ShimmerAnimation by providing the following parameters:

items: A list of ShimmerItem objects that define the shape and size of the shimmer items.
itemsPaddingDp: The padding between each shimmer item.