import React from "react";
import {Stack, TextField} from "@mui/material"

const textFieldStyle = {
    color: 'white', //field
};

const labelStyle = {
    color: 'grey', //label
};

export const MuiTextField = () => {
    return (

            <Stack spacing={1} style={{ zIndex: 2, marginLeft: '1rem'}}>
            <Stack direction="row" spacing={1} />

            <Stack direction='row' spacing={1}>
                <TextField label='Id' variant='outlined' style={textFieldStyle} InputLabelProps={{ style: labelStyle }}/>
            </Stack>

            {/* Name */}
            <Stack direction="row" spacing={1}>
                <TextField label="Name" variant="outlined" style={textFieldStyle} InputLabelProps={{ style: labelStyle }}/>
            </Stack>

            {/* Gender */}
            <Stack direction="row" spacing={1}>
                <TextField label="Gender" variant="outlined" style={textFieldStyle} InputLabelProps={{ style: labelStyle }}/>
            </Stack>

            {/* Age */}
            <Stack direction="row" spacing={1}>
                <TextField label="Age" variant="outlined" style={textFieldStyle} InputLabelProps={{ style: labelStyle }}/>
            </Stack>

            {/* Weight */}
            <Stack direction="row" spacing={1}>
                <TextField label="Weight" variant="outlined" style={textFieldStyle} InputLabelProps={{ style: labelStyle }}/>
            </Stack>

            {/* Height */}
            <Stack direction="row" spacing={1}>
                <TextField label="Height" variant="outlined" style={textFieldStyle} InputLabelProps={{ style: labelStyle }}/>
            </Stack>

            {/* Number of Training Days */}
            <Stack direction="row" spacing={1}>
                <TextField label="Number of Training Days" variant="outlined" style={textFieldStyle} InputLabelProps={{ style: labelStyle }}/>
            </Stack>

            {/* Active Metabolic Rate */}
            <Stack direction="row" spacing={1}>
                <TextField label="Active Metabolic Rate" variant="outlined" style={textFieldStyle} InputLabelProps={{ style: labelStyle }}/>
            </Stack>

            {/* Objective */}
            <Stack direction="row" spacing={1}>
                <TextField label="Objective" variant="outlined" style={textFieldStyle} InputLabelProps={{ style: labelStyle }}/>
            </Stack>
            <Stack direction="row" spacing={1} />
        </Stack>
    )
}