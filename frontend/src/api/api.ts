const API_URL = import.meta.env.VITE_API_BASE_URL ?? "http://192.168.0.11:8081/api";

export const getUser = () => {
    return fetch(API_URL + "/user");
};

export const getUsers = () => {
    return fetch(API_URL + "/users");
};

