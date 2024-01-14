import * as React from 'react';
import {Stack} from "@mui/material";
import {Button} from "@mui/material";
//import {Link} from "react-router-dom";

const HeaderButtons: React.FC = () => {
    return (
        <Stack spacing={2} direction="row" justifyContent={"flex-end"}>
            <Button variant="contained" href={"/"}>Home</Button>
            <Button variant="contained" href={"/diet"}>Diet</Button>
            <Button variant="contained" href={"/training"}>Training</Button>
        </Stack>
    );
}
export default HeaderButtons;