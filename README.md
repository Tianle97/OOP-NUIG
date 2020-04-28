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
There is an abstract class(CatalogueData.java), because Films and TVSeries have some same attr. For the avoid code redundant, I create this abstract class. It can reduce the number of the same code.
</br>
 ![mvc](https://github.com/Tianle97/OOP-NUIG/blob/master/Final_Assignment/mvc.png)
</br>
The generation of new objects for films and TV series implemented using a factory
pattern (Abstract Factory or Factory Method).
