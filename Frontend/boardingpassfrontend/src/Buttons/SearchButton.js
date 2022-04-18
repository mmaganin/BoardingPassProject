import React from "react";
import { Link } from "react-router-dom";
//TODO: wire up functionality with MTA API call
//TODO: handle search submission to query MTA with results
function SearchButton() {
 return (
  <Link to="/searchresults">
   <button type="button" class="btn btn-primary">
    Search
   </button>
  </Link>
 );
}

export default SearchButton;
