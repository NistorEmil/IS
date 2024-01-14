import React from 'react';
import Header from "../components/header";
import { useLocation } from 'react-router-dom';

function Diet() {
    const location = useLocation();
    const { personId } = location.state || {}
    const selectedPerson = location.state?.selectedPerson || null;
    console.log(selectedPerson)

    return (
        <div>
            <Header></Header>
            <div>
                Diet Page
                {selectedPerson && (
                    <div>
                        Selected Person: {selectedPerson.name}
                        {/* Display other information as needed */}
                    </div>
                )}
            </div>
        </div>
    );
}

export default Diet;