# Deliverable3
Yifan Zhao
YIZ105@pitt.edu

The first obstacle that I faced with was writing user stories for the online store site. This turned out to be very easy and very difficult all at once. You have to analyze the site from the perspective of customers. So the user stories that I choose seem somewhat generic, but mainly focused on the functionality of the site.

Coming up with the scenarios that I also took some time to think 9 scenarios. At first, I want to test whether I could find the product name in the 3-rotation banners. But soon I find out that as the banner is rotated, the order of the product banner is changed every few seconds. So it’s difficult for me to test the specific product name in these 3 banners. 

Determining how to test the search functionality took me some thinking. As there was no submit type in the input tag, I tried many times to find the proper way to realize the function. When I was trying different method to test the search function, I found the test result sometimes went wrong, but sometimes went good. But finally, it worked out after I add the “Keys.RETURN” string when sent keys in the search textbox and use explicit wait to wait the loading of a new page. 

Likewise, I also took some time to test the login functionality. I tried many different kind ways, including by form id and input class. At last, however, I found out the reason why the log in test didn’t work. It finally ended up using explicit wait to fix the bugs. You had to wait until the page was directed to a new page. 

All in all, all the tests I wrote were passed. I found this testing process to be enlightening. It certainly seems useful to be able to run tests like these on a real website. It’s nice to know how to do this last semester for my web development class.

Below lists all 3 user stories and 9 scenarios.
1. User story 1 
As a new customer, 
I want to view this site for more information. 
So that I can know what kind of products the online store have.
¬	Scenario 1: 
Given that I am on the online store site
When I view the title of the page
Then I see that it contains the word "ONLINE STORE"
¬	Scenario 2: 
Given that I am on the online store site
When I look at the top of the page
Then I should see a search textbox
¬	Scenario 3: 
Given that I am on the online store site
When I click on the "All Product" menu link
Then I should see a new directed page
¬	Scenario 4:
Given that I am going to buy the product 
When I click the "Buy Now" button
Then I should see a "Add To Cart" button

2. User story 2
As a new customer, 
I want to search products. 
So that I will find what I want to buy and then add to cart.
¬	Scenario 5: 
Given that I want to buy a mouse,
When I type the mouse in search box,
Then I should see a search result page.
¬	Scenario 6: 
Given that the mouse search result page comes out,
When I click the "Add to Cart" button,
Then I should see the mouse in the cart.

3. User story 3
As a new customer, 
I want to create my own account. 
So that I can log in the site.
¬	Scenario 7: 
Given that I amd in the homepage and I want to create an account,
When I click on the "Account" icon
Then I should see the "Register" text.
¬	Scenario 8: 
Given that I have already created an account
When I go to the login page and type my username and wrong password
Then I should see a login error message
¬	Scenario 9: 
Given that I have already created an account
When I go to the login page and type my username and password
Then I should see "(Logout)" text
