# Pokemon API

We are Pokemon trainers, a team consisting of [BNTA](https://techacademy.brightnetwork.co.uk/) Cohort 5 members : [Bianca](https://github.com/biancakendall29), [Naim](https://github.com/N41M) and [Amber](https://github.com/aakamara)


# Table of Contents
- [Summary](#summary)
- [Step-by- step instructions for inital set-up](#step-by-step-instructions-for-initial-set-up)
- [Project Structure](#project-structure)
- [Using the API - HTTP Requests](#using-the-api---http-request)
    - [Pokemon Commands](#pokemon-commands)   
    - [Other Commands](#other-commands)


# Summary
This collaborative project was completed as part of the Bright Network Technology Academy programme. This project consists of a Trainers who can collect Pokemon to help them fight one of the many gym leaders which based on a classical video game called Pokemon.

The API was created using Java, and Spring boot, as well as, using Postman for testing. 

There is a mode:
- A *battle function* that will allow a trainer to battle against another trainer or gym leader where the end result is randomised and the winning Pokemon increases in its level

Our project requirements and development schedule can be found [here](https://github.com/biancakendall29/w07_server_side_project/blob/main/plan.md).

# Step-by-step instructions for initial set up
1. Make sure that you have installed Java.

2. Clone this repository : `git clone git@github.com:biancakendall29/w07_server_side_project.git` and open in you Java IDE

3. If you don't already have it, download Postman so that you can interact with the API, the HTTP quereis you will make will be on : `localhost:8081/(command inserted here)`

# Project Structure

## Entity Relationship (ER) Diagram

![This is an image](https://github.com/biancakendall29/w07_server_side_project/blob/main/Entity_relationship_diagram2.JPG)


# Using the API - HTTP Request
## Plain Old Java (POJO)
In this section, the POJOs used in the project are listed along with their properties and related JSON structure when using some `POST`and `GET` requests.

The API can be used with the following HTTP requests, in the Postman desktop application:

## Pokemon Commands
### @GET
To get the list of all pokemon : `localhost:8081/pokemons` 
To get a specific pokemon, if you know the id, your format should be as follows `localhost:8081/pokemons/{id}`

> where you replace {id} with a known id number

### @POST
Ensure your Postman is set to run a HTTP `POST` request : `localhost:8081/pokemons`

Now input the pokemon data. This should be done in the `JSON` Object format within the body where it should look like so :

        {
            "name" : "";
            "type" : --;
            "level" : --;
        }

### @PUT
Ensure your Postman is set to run a HTTP `PUT` request where you update a pokemon.

If you have already added a pokemon from the example but you want to change one of their properties such as their level. It is similar to adding a pokemon but you will need to know the id number and the command for what you want to change. Run the code `localhost:8081/pokemon/changeLevel/{id}/{the level you want}`

> The `PUT` requests do not save permanetly 

### @DELETE
Ensure your Postman is set to run a HTTP `DELETE` request so you can delete a pokemon.
Imagine you have already added a Pokemon from the example, however, you want to delete that record. Again, run : `localhost:8081/pokemon/{id}`

> where {id} can be replaced with an id of the pokemon you want to delete

To delete all Pokemon, simiply run `localhost:8081/pokemons/` with the `@DELETE` request selected, it will delete all records. You must **BE CARFUL** when doing this as it is **NOT** reversible.

 > Also, is you add more Pokemon, the previous IDs will not be used again.


## Other Commands
These commands work as the Pokemon commands shown above, except with a different command substituted for 'pokemons'
| HTTP Request      | Trainer |  Gym    |  Gym Leader  |
| :---        |    :----   |          :---- |        :---|
| `POST`      | `localhost:8081/trainers/`   | `localhost:8081/gyms/` | `localhost:8081/gymLeaders/` |
| `GET`' | `localhost:8081/trainers/`       | `localhost:8081/gyms/`   | `localhost:8081/gymLeaders/` |
| `PUT`  | `localhost:8081/trainers/{command name}/{id}/{what you need to change}`       | `localhost:8081/gyms/{command name}/{id}/{what you want to change}`   | `localhost:8081/gymLeaders/{command name}/{id}/{what you want to change}` |
| `DELETE`  | `localhost:8081/trainers/{id}`        | `localhost:8081/gyms/{id}`   | `localhost:8081/gymLeaders/{id}` |

# Further Implementation and Extensions
If were to add further implementations to the project, they would be as follows:

## Non-Technical Measures
Test Driven Development (TDD) would be used as we did not implement it from the beginning of the project

## Technical Measures
We would like to complete the battle functionality where you can pick or choose a Pokemon's ability when they in a battle which would be similar to the video game itself.

Some Pokemon do not have just one attribute type but two so we wanted to implement two enums into a variable then implement a derived query to select the pokemon of a certain attribute type, for example, finding a water type pokemon. However, this deemed to be more complex than what we initially thought.

## Quirky behaviour
Although the PUT requests all work as expected when they are sent and viewed in the Postman PUT request response window, the changes made do not save permanently to the repository, and therefore don't appear in the GET requests afterwards.

# Acknowledegements
A massive thanks to the [BNTA](https://techacademy.brightnetwork.co.uk/) team, and especially to our trainers [Richard](https://github.com/biancakendall29/w07_server_side_project#summary) and [Anna](https://github.com/biancakendall29/w07_server_side_project#summary)!
