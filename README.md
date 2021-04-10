# KuesionerKu ![Made With](https://img.shields.io/badge/made%20with-kotlin-blueviolet)
An Android application that connects people who are looking for questionnaire respondents with people who are willing to become questionnaire respondents for a fee. This application was developed for Pengembangan Aplikasi Piranti Bergerak 2021 course project.

## Features
Kuesionerku allows **surveyors** to:
* Create questionnaires to be published to potential respondents
* Set the created questionnaire with the following settings:
    * number of required respondents
    * allocated fee for each respondents
    * types of respondents needed (eg. a pregnant woman)
* Top up balance to be used for questionnaire respondents’ fee
* Automatically transfers allocated fee without the hassle of manually transferring 

and **respondents** to:

* Earn money from answering questionnaires
* Look at recommended questionnaires for him/her
* Look for questionnaires of a certain category or type of respondent needed
* Cash out earned money

## Overview 
This app is still in development for the respondent side of the app. Hence, not all features are implemented yet. As of this update, SurveyKu implements the following:

### Screens
No  | Name | Content | Preview
:------------: | :-------------: | ------------- | :-------------:
1  | Login  |  - email input <br> - password input <br> - login button | <img src="/Preview/Login.jpeg" width="120"/>
2 | Beranda  |   - greetings to the user <br> - user balance <br> - number of questionnaires filled <br> - recommended questionnaires for the user | <img src="/Preview/Beranda.jpeg" width="120"/>
3 | Eksplorasi  |   - a search bar  <br> - a category spinner  <br>- trending questionnaires | <img src="/Preview/Eksplorasi.jpeg" width="120"/>
4 | Profil  |  - user’s personal information <br> - user balance <br> - number of questionnaires filled <br> - logout button <br> - promotion dialog | <img src="/Preview/Profil.jpeg" width="120"/>

### Dialog
   
No  | Name | Content | Preview
:-------------: | :-------------: | ------------- | :-------------:
1  | Promotion  | promotional banner | <img src="/Preview/PromotionBanner.jpeg" width="120"/>

### Navigation
Login screen is first displayed when application is run. After logging in, user will be navigated to Beranda. A bottom navigation bar is provided to manually navigate between Beranda, Eksplorasi, and Profil screen.

### Lifecycle
Implemented methods:

* **onCreate()**
<br> Associate each activities and fragments with corresponding ViewModels.

* **onResume()**
<br> Promotion dialog shows up when Beranda fragment is resumed.

Our team has not found yet meaningful implementations of the remaining methods, thus we did insert them to each fragments but only outputting a log. However, the logs helped us observe directly Android application lifecyle .

### Architecture
KuesionerKu implements MVP architecture. We selected this architecture because it's easy to maintain and expandable. One of the factors that causes this is the fact that the data used in SurveyKu is detached from the views that's on display. This will make both, the data and the views, be expanded and maintained independently.

## Changelog
Week  | Change 
:-------------: | ------------- 
5  | Created 3 screens and 2 navigations (screen1 <--> screen2 <--> screen3)
6  | Implemented lifecycle methods
7  | Implemented Model-View-Presenter architecture

## Contributing
Contributions are welcome! Just create a new [issue](https://github.com/victoriatrinita/papb-2021/issues) or [pull request](https://github.com/victoriatrinita/papb-2021/pulls).

## Authors
Group 4
* M Luqman Hakim              18/425315/TK/47010
* Ignatius A. A. Saragih       18/429069/TK/47571
* Victoria Trinita Pardede      18/425325/TK/47020

---

<h3 align="center"><pre>
<a href="LICENSE">MIT License</a>
</pre></h3>

