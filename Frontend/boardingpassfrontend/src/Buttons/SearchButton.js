import React from "react";
import { Link, useLocation } from "react-router-dom";
//TODO: wire up functionality with MTA API call
//TODO: handle search submission to query MTA with results
function SearchButton(props) {

    var inputs = [props.from, props.dateTime, props.firstName, props.lastName, props.email, props.phoneNumber, props.age, props.selectedGender]
    return (
        <Link to="/searchresults" state={inputs}>
            <button type="button" class="btn btn-primary">
                Search
            </button>
        </Link>
    );
}

export default SearchButton;
