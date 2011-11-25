This is an example project which shows how to setup and use aop logging
in a java webapp.

To run the project:

    $ mvn tomcat:run

Fire up this url in your browser: http://localhost:8080/aop-logging-example

You should see something like the following in your console each time you refresh the web page:

aop-logging-example: 13:02:14.591 [http-8080-1] DEBUG com.nexse.swat.example.service.DefaultOrderService - order(): [Customer{fullName='Arthur Dent', address='The Galaxy'}, Product{id=42, name='Hitchhicker's Guide to the Galaxy'}]
aop-logging-example: 13:02:14.592 [http-8080-1] DEBUG com.nexse.swat.example.service.DefaultOrderService - order(): result=Order{status=PROCESSED, timestamp=Fri Nov 25 13:02:14 CET 2011, customer=Customer{fullName='Arthur Dent', address='The Galaxy'}, product=Product{id=42, name='Hitchhicker's Guide to the Galaxy'}}
