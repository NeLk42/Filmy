Filmy Android App
===================================

This app displays a list of movies, extracting information
from the [Movie DB](https://www.themoviedb.org).

This project is being written as a deliverable for
the Udacity course in the Android Nanodegree.

More info on the The Movie DB API available at:
https://www.themoviedb.org/documentation/api

Pre-requisites
--------------

- Android SDK v25
- Android Build Tools v25.2.0
- Android Support Repository v25.2.0
- Replace fake MovieDB API Key with your own.

Getting Started
---------------

This sample uses the Gradle build system. To build this project, use the
"gradlew build" command or use "Import Project" in Android Studio.

For The MovieDB REST calls to work you will need to replace the fake key
located at `/app/java/filmy.nelk.io.filmy/retrofit/MovieDBKey` with your
own API key, more information on how to obtain an API Key for MovieDB can
be found here : https://developers.themoviedb.org/3/getting-started.

To untrack said file when/if you clone this repo use :
`git update-index --assume-unchanged /<Path>/MovieDBKey.java`

Support
-------

- Google+ Community: https://plus.google.com/communities/105153134372062985968
- Stack Overflow: http://stackoverflow.com/questions/tagged/android

License
-------

Copyright 2016 The Android Open Source Project, Inc.

Licensed to the Apache Software Foundation (ASF) under one or more contributor
license agreements.  See the NOTICE file distributed with this work for
additional information regarding copyright ownership.  The ASF licenses this
file to you under the Apache License, Version 2.0 (the "License"); you may not
use this file except in compliance with the License.  You may obtain a copy of
the License at

http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.  See the
License for the specific language governing permissions and limitations under
the License.
