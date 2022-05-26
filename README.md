# Pokemon API

We are Pokemon trainers, a team consisting of [BNTA](https://techacademy.brightnetwork.co.uk/) Cohort 5 members : [Bianca](https://github.com/biancakendall29), [Naim](https://github.com/N41M) and [Amber](https://github.com/aakamara)


# Table of Contents
- [Summary](#summary)
- [Step-by- step instructions for inital set-up](#step-by-step-instructions-for-initial-set-up)
- [Project Structure](#project-structure)
- [Methods](#methods)
- [Using the API - HTTP Requests](#using-the-api---http-request)
    - [Pokemon Commands](#pokemon-commands)   
    - [Other Commands](#other-commands)


# Summary
This collaborative project was completed as part of the Bright Network Technology Academy programme. This project consists of a Pokemon ---, based on a classical video game called Pokemon.

The API was created using Java, SpringBoot, and PostgresQL, as well as, using Postman for testing. 

There are two modes:


# Step-by-step instructions for initial set up

# Project Structure

## Entity Relationship (ER) Diagram

insert the diagram here

# Methods
See below for a list of methods used in each class and their descriptions:


# Using the API - HTTP Request
## Plain Old Java (POJO)
In this section, the POJOs used in the project are listed along with their properties and related JSON structure when using `POST`and `PUT` requests:

| HTTP Request      | Type | Function    |
| :---        |    :----   |          :--- |
| Pokemon      | properties    | code  |
| Trainer  | properties        | code    |
| Gym  | properties        | code    |
| Gym Leader  | properties        | code    |

The API can be used with the following HTTP requests, in the Postman desktop application:

## Pokemon Commands
### @GET
To get the list of all pokemon : `localhost:8081/pokemon` 
To get a specific pokemon, if you know the id, your format should be as follows `localhost:8081/pokemon/{id}`

-- where you replace {id} with a known id number --

### @POST
Ensure your Postman is set to run a HTTP `POST` request : `localhost:8081/pokemon`

Now input the pokemon data. This should be done in the `JSON` Object format within the body where it should look like so :

        {
            "name" : "";
            "type" : --;
            "level" : --;
        }

### @PUT
Ensure your Postman is set to run a HTTP `PUT` request where you update a pokemon.

If you have already added a pokemon from the example but you want to change one of their properties such as their level. It is similar to adding a pokemon but you will need to know the id number. Run the code `localhost:8081/pokemon/{id}` and insert the new body as:

        {
            "name" --;
            "type" --;
            "level" --;
        }


### @DELETE
Ensure your Postman is set to run a HTTP `DELETE` request so you can delete a pokemon.
Imagine you have already added a pokemon from the example, however, you want to delete that record. Again, run : `localhost:8081/pokemon/{id}`

-- where {id} can be replaced with an id of the pokemon you want to delete --

To delete all pokemon, simiply run `localhost:8081/pokemon/` with the `@DELETE` request selected, it will delete all records. You must **BE CARFUL** when doing this as it is **NOT** reversible.

Also, is you add more pokemon, the previous IDs will not be used again.


## Other Commands
These commands work as the pokemon commands shown above, except with a different command substitutied for 'pokemon'
| HTTP Request      | Trainer |  Gym    |  Gym Leader  |
| :---        |    :----   |          :---- |        :---|
| `POST`      | `localhost:8081/trainer/`   | `localhost:8081/gym/` | `localhost:8081/gymLeader/` |
| `GET`' | `localhost:8081/trainer/`       | `localhost:8081/gym/`   | `localhost:8081/gymLeader/` |
| `PUT`  | `localhost:8081/trainer/{id}`       | `localhost:8081/gym/{id}`   | `localhost:8081/gymLeader/{id}` |
| `DELETE`  | `localhost:8081/trainer/{id}`        | `localhost:8081/gym/{id}`   | `localhost:8081/gymLeader/{id}` |

# Further Implementation and Extensions
If were to add further implementations to the project, they woudl be as follows:

## Non-Technical Measures

## Technical Measures
We would like to complete the battle functionality where you can pick or choose a Pokemon's ability when they in a battle which would be similar to the video game itself.

We ...

# Acknowldegements
A massive thanks to the [BNTA](https://techacademy.brightnetwork.co.uk/) team, and especially to our trainers [Richard](https://github.com/biancakendall29/w07_server_side_project#summary) and [Anna](https://github.com/biancakendall29/w07_server_side_project#summary)!
