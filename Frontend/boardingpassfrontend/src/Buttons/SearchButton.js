import React from "react";
import { Link } from "react-router-dom";
//TODO: wire up functionality with MTA API call
//TODO: handle search submission to query MTA with results
function SearchButton(props) {
    return (
        <Link to={{
            pathname: "/searchresults",
            state: {
                from: props.from,
                to: props.to
            }
        }}>
            <button type="button" class="btn btn-primary">
                Search: {props.from} + {props.to}
            </button>
        </Link>
    );
}

export default SearchButton;
