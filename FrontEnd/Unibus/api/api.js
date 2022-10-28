import axios from 'axios';

export default function api(){
    axios.create({baseURL:"https://localhost:8080"})
}