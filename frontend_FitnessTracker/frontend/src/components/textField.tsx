import React, {useEffect, useState} from "react";
import {Stack, TextField, Button, Select, MenuItem} from "@mui/material";
import axios from 'axios';
import {Simulate} from "react-dom/test-utils";
import error = Simulate.error;

const textFieldStyle = {
    color: 'white', //field
};

const labelStyle = {
    color: 'grey', //label
};

interface MuiTextFieldProps {
    onInsertPerson: (person: any) => void;
    onSelectPerson: (personId: number | null) => void;
}

interface Person {
    id: number;
    name: string;
    gender: string;
    age: number,
    weight: number,
    height: number,
    numberOfTrainingDays: number,
    activeMetabolicRate: string,
    objective: string
    // Alte proprietăți ale obiectului Person...
}

const MuiTextField: React.FC<MuiTextFieldProps> = ({ onInsertPerson, onSelectPerson }) => {
    const [personData, setPersonData] = useState({
        name: "",
        gender: "",
        age: "",
        weight: "",
        height: "",
        numberOfTrainingDays: "",
        activeMetabolicRate: "",
        objective: "",
    });

    const [allPersons, setAllPersons] = useState<Person[]>([]);
    const [selectedPerson, setSelectedPerson] = useState<Person | null>(null);



    useEffect(() => {
        // Funcție pentru a obține toate persoanele și a le seta în starea 'allPersons'

        axios.get('http://localhost:8080/Person/findAll', {
            headers: {
                "content-type": "application/json"
            }
        }).then(response => {
            console.log(response.data);
            setAllPersons(response.data);
        }).catch(error => console.error('Error fetching accounts:', error));

        // Apelarea funcției pentru a obține persoanele atunci când componenta este montată
    }, [personData]);  // [] ca al doilea argument pentru a asigura că se efectuează doar la montarea componentei

    const handleInputChange = (field: string, value: string | number) => {
        setPersonData((prevData) => ({
            ...prevData,
            [field]: value,
        }));
    };

    const handleInsertPerson = () => {
        const areAllFieldsFilled = Object.values(personData).every(value => value !== null && value !== "");

        if (!areAllFieldsFilled) {
            alert("Please fill in all fields.");
            return;
        }
        const apiUrl = 'http://localhost:8080/Person/Insert';

        axios.post(apiUrl, personData, {
            headers: {
                'Content-Type': 'application/json',
            },
        })
            .then(response => {
                console.log(response.data);
                alert(`Person inserted successfully`);
            })
            .catch(error => {
                console.error(error.response.data);
                alert(`Error: ${error.response.data}`);
            });

        onInsertPerson(personData);
        setPersonData({
            name: "",
            gender: "",
            age: "",
            weight: "",
            height: "",
            numberOfTrainingDays: "",
            activeMetabolicRate: "",
            objective: "",
        });
    };

    const handleDietButtonClick = () => {
        if (selectedPerson) {
            onSelectPerson(selectedPerson.id);
            // Here, you might need to implement the logic to redirect or pass this ID to the diet page.
            // For example, if using React Router, you might use history.push('/diet-page', { personId: selectedPerson.id });
        } else {
            alert("Please select a person before pressing Diet.");
        }
    };

    return (
        <Stack spacing={1} style={{ zIndex: 2, marginLeft: '1rem' }}>
            <Stack direction="row" spacing={1} />

            {/* Dropdown cu toate persoanele */}
            <Select
                label="Select a person"
                value={selectedPerson ? selectedPerson.id : ''}
                onChange={(e) => {
                    const selectedId = parseInt(e.target.value as string, 10);
                    const selected = allPersons.find(person => person.id === selectedId) || null;
                    setSelectedPerson(selected);
                }}
            >
                {allPersons.map((person) => (
                    <MenuItem key={person.id} value={person.id}>
                        {person.name}
                    </MenuItem>
                ))}
            </Select>
            {/* Restul câmpurilor */}
            <Stack direction="row" spacing={1}>
                <TextField label="Name" variant="outlined" style={textFieldStyle} InputLabelProps={{ style: labelStyle }}
                           value={personData.name} onChange={(e) => handleInputChange('name', e.target.value)} />
            </Stack>

            <Stack direction="row" spacing={1}>
                <TextField label="Gender" variant="outlined" style={textFieldStyle} InputLabelProps={{ style: labelStyle }}
                           value={personData.gender} onChange={(e) => handleInputChange('gender', e.target.value)} />
            </Stack>

            <Stack direction="row" spacing={1}>
                <TextField label="Age" variant="outlined" style={textFieldStyle} InputLabelProps={{ style: labelStyle }}
                           value={personData.age} onChange={(e) => handleInputChange('age', parseInt(e.target.value) || 0)} />
            </Stack>

            <Stack direction="row" spacing={1}>
                <TextField label="Weight" variant="outlined" style={textFieldStyle} InputLabelProps={{ style: labelStyle }}
                           value={personData.weight} onChange={(e) => handleInputChange('weight', parseFloat(e.target.value) || 0)} />
            </Stack>

            <Stack direction="row" spacing={1}>
                <TextField label="Height" variant="outlined" style={textFieldStyle} InputLabelProps={{ style: labelStyle }}
                           value={personData.height} onChange={(e) => handleInputChange('height', parseFloat(e.target.value) || 0)} />
            </Stack>

            <Stack direction="row" spacing={1}>
                <TextField label="Number of Training Days" variant="outlined" style={textFieldStyle} InputLabelProps={{ style: labelStyle }}
                           value={personData.numberOfTrainingDays} onChange={(e) => handleInputChange('numberOfTrainingDays', parseInt(e.target.value) || 0)} />
            </Stack>

            <Stack direction="row" spacing={1}>
                <TextField label="Active Metabolic Rate" variant="outlined" style={textFieldStyle} InputLabelProps={{ style: labelStyle }}
                           value={personData.activeMetabolicRate} onChange={(e) => handleInputChange('activeMetabolicRate', e.target.value)} />
            </Stack>

            <Stack direction="row" spacing={1}>
                <TextField label="Objective" variant="outlined" style={textFieldStyle} InputLabelProps={{ style: labelStyle }}
                           value={personData.objective} onChange={(e) => handleInputChange('objective', e.target.value)} />
            </Stack>
            <Stack direction="row" spacing={1} />
            <Button variant="contained" onClick={handleInsertPerson}>
                Insert
            </Button>
            {/* Butonul Diet */}
            <Button variant="contained" onClick={handleDietButtonClick}>
                Diet
            </Button>
        </Stack>
    );
};

export default MuiTextField;