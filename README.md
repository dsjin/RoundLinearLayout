# RoundLinearLayout
[![](https://jitpack.io/v/dsjin/RoundLinearLayout.svg)](https://jitpack.io/#dsjin/RoundLinearLayout)
Simple Round Linear Layout ( android widget ) / not smooth edge
## Screen Sample
![Screenshot](https://imgur.com/pAuzDyr.gif?1)
## Dependency
* add on build.gradle project level
```xml
allprojects {
	repositories {
		...
		maven { url 'https://jitpack.io' }
	}
}
```
* add on build.gradle app level - dependencies scope
```xml
implementation 'com.github.dsjin:RoundLinearLayout:{version}'
```
## Attributes
| Variable  | Type  | Description |
| :---------:|:------:| :-----:|
| radius | Int | radius of layout's corner (default : 10 )|

## Usage
* You can use like a linear layout but if you want to make layout round add `radius` attribute
### On layout xml
```xml
<com.github.dsjin.RoundLinearLayout
     ...
     app:radius=50/>
```
### On programmatically
```kotlin
val layout : RoundLinearLayout = findViewById(resource)
layout.setRadian(50)
```
## License
```
Copyright 2019 Thatchakon Jom-ud

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

    http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
```
