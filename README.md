# Final-Assignment 50% 

> Model: CT548 Object Oriented Design and Development

> Student: Tianle Shu

> Student Id: 19232619

> Lecturer: Dr.UMAIR UL HASSAN & Dr.ALESSANDRO ADAMOU

## Overview
Design and implement a media catalogue that allows a user to browse through films and TV series
and to create their own media library from the catalogue. 

## Design Patterns
This system I designed and implemented using model-view-controller (MVC): user
interface code shall never directly access the data. </br> 
* I write model classes in the packge(*nuig.oop.model*)
There is an abstract class(CatalogueData.java), because Films and TVSeries have some same attr. For the avoid code redundant, I create this abstract class. It can reduce the number of the same code.</br> 

 ![mvc](https://github.com/Tianle97/OOP-NUIG/blob/master/Final_Assignment/mvc.png )
 
* The generation of new objects for films and TV series implemented using a factory
pattern (Abstract Factory or Factory Method). </br> 


*__What is Factory pattern Design__* ? </br>
定义一个接口或抽象类，去创造实类。</br>
**Factory pattern** is one of the most used design patterns in Java. This type of design pattern comes under creational pattern as this pattern provides one of the best ways to create an object.</br>

*__The Advantages of Factory Design Pattern__*
1. Factory design pattern provides approach to code for interface rather than implementation. 
1. Factory pattern removes the instantiation of actual implementation classes from client code. Factory pattern makes our code more robust, less coupled and easy to extend. 
   1. For example, we can easily change PC class implementation because client program is unaware of this.
1. Factory pattern provides abstraction between implementation and client classes through inheritance. </br></br>
This picture is my factory design pattern in this system(generation of new objects for films and TV series implemented by factory pattern): </br>
![factory](https://github.com/Tianle97/OOP-NUIG/blob/master/Final_Assignment/factory_uml.png)
**Code Explain** </br>
In the `Factory` interface I create a method
```java
public interface Factory {
	public Object getInstance();
}
```
For the 2 Classes (`FilmFactory` and `TVFactory`) implements `Factory` interface `getInstance()` method respectly.
```java
public class FilmFactory implements Factory{

	public Films getInstance() {
		return Films.getInstance();
	}
	
}

public class TVFactory implements Factory {

	public TVseries getInstance() {
		return TVseries.getInstance();
	}

}
```
I let the `Films` and `TVSeries` classes is called by the upper 2 classes(`FilmFactory` and `TVFactory`) respectively.
and also use Singleton Design pattern to create the new instance.
```java
public class Films extends Midia {
	private int fid;
	private String director;

	private Films() {
	}

	public static Films getInstance() {
		return new Films();
	}
 }
 
 public class TVseries extends Midia {
	private int tid;
	private String creator;

	private TVseries() {
	}

	public static TVseries getInstance() {
		return new TVseries();
	}
 }
```
*__What is Strategy pattern Design__* ? </br>
##  Small Guide for Using this System
* Download this Java Project from Blackbaord, or go to this [GithubLink](https://github.com/Tianle97/OOP-NUIG) to download.
  * > And unzip this project.
  * > At the same time open your eclipse or intelliJ (for import this project to IDE work place).
* Go to `nuig.oop.runtime` pacakge , find the `App.java`.
  * > right click this class -> Run As -> Java Application.
* Then you can see the *__Video Catalogue__* frame (main frame) on the center of the screen

## How the media item creation subsystem can be extend
* create movies and series that are physical (e.g. on DVD or Blu-ray) separate from digital ones (e.g. streaming or downloadable files). 
  > Because the `Films` and `TVSeries` , they have many same attr. 
  > So I create an abstract class called `Media`, it is a super-class of `Films` and `TVSeries`

* Design the way of resolve
  * > Firstly, we need create an interface and named `Production`. Let the abstract class `Media` to implememt it.
  * > Then give 4 methods in this interface. (In the sub-classes `Films` and `TVSeries` to implements that 4 methods )
  * > 1st method: `packageToCD()` . Let the movies or tvseries package to CD.
  * > 2nd method: `processToStream()`. Let the movies or tvseries to Stream (e.g. user wacth vedio on the screen online)
  * > 3th method: `processToDownload()`. Let the movies or tvseries can dowload.
  * > 4th method: `packageToBlue_Ray()`. Let the movies or tvseries package to Blue_Ray.
* Also that 4 method, concret implement in `Films` and `TVSeries` class.
* The sample uml diagram:
![puml](https://github.com/Tianle97/OOP-NUIG/blob/master/Final_Assignment/p_uml.png)
		

## System Extend
		
		
		
