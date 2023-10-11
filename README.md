# viewshow
華納威秀影城<br></br>
URL : https://www.vscinemas.com.tw/vsweb/

## Side Project Purpose
Recently I reviewed my programing school work (It's been more than 1 year), I still recalled some good pratices about ER Model Design . <br></br>
By that time I could't figure out how to build proper relations in these tables, it would never work properly anyway ! <br></br>
Here I was thinking to redo this model again and put it with backend together.   

## ER Model
If you take a look of this website from table perspective, you can see Theater and Movie have ManyToMany relations. Movie and Datetime also have ManyToMany relations. After clinet has well chosen
Theater, Movie and Datetime , he could be able to select Sessions for next round. So, if you see Theater, Movie and Datetime as a composite entity, then it has a OneToMany relation
with Sessions.

* As showed below was my previous ER Model to attain viewshow movie session search :

<img width="932" alt="Screen Shot 2023-10-11 at 3 53 38 PM" src="https://github.com/chenchenghung/viewshow/assets/29514988/572c0b78-2dbb-4248-a422-8e5a3e0e3e3f">
<br></br>

* The redo version below :

<img width="947" alt="Screen Shot 2023-10-11 at 4 22 20 PM" src="https://github.com/chenchenghung/viewshow/assets/29514988/c21c4b71-e3c5-463f-a62d-2a7eac32e5e2">

