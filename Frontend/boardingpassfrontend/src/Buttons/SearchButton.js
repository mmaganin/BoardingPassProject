import React from "react";
import { Link, useLocation } from "react-router-dom";
//TODO: wire up functionality with MTA API call
//TODO: handle search submission to query MTA with results
function SearchButton(props) {
    return (
        <Link to={"/searchresults"}>
            <button type="button" class="btn btn-primary">
                Search
            </button>
        </Link>
    );
}

export default SearchButton;
