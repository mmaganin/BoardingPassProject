import React from "react";
import SearchButton from "../Buttons/SearchButton";

const Welcome = () => {
 return (
  <div className="welcome-page">
   <div className="container">
    <h1 className="display-4">Welcome to Boarding Pass!</h1>
    <h2 className="display-3">Please enter To and From destinations.</h2>
    <p> eg: Los Angeles, CA, New York, NY</p> 
    <div class="search-form input-group mb-3">
     <span class="input-group-text" id="inputGroup-sizing-default">
      From:
     </span>
     <input
      type="text"
      class="form-control"
      aria-label="Sizing example input"
      aria-describedby="inputGroup-sizing-default"
     ></input>
    </div>
    <SearchButton />
   </div>
  </div>
 );
};

export default Welcome;
