# Final-Assignment 50% 

> Model: CT548 Object Oriented Design and Development

> Student: Tianle Shu

> Lecturer: Dr.UMAIR UL HASSAN & Dr.ALESSANDRO ADAMOU

## Overview
Design and implement a media catalogue that allows a user to browse through films and TV series
and to create their own media library from the catalogue. 

## Design Patterns
This system I designed and implemented using model-view-controller (MVC): user
interface code shall never directly access the data. </br> 
* I write model classes in the packge(*nuig.oop.model*)
There is an abstract class(CatalogueData.java), because Films and TVSeries have some same attr. For the avoid code redundant, I create this abstract class. It can reduce the number of the same code.</br> 

 ![mvc](https://github.com/Tianle97/OOP-NUIG/blob/master/Final_Assignment/mvc.png)
* The generation of new objects for films and TV series implemented using a factory
pattern (Abstract Factory or Factory Method). </br> 
*What is Factory pattern Design* ? </br>
定义一个接口或抽象类，去创造实类。</br>
Factory pattern is one of the most used design patterns in Java. This type of design pattern comes under creational pattern as this pattern provides one of the best ways to create an object.</br>
This picture is my factory design pattern in this system: </br>
![factory](https://github.com/Tianle97/OOP-NUIG/blob/master/Final_Assignment/factory_uml.png)
