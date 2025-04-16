import {useEffect, useState} from "react";
import {getUser} from "./api/api";
import {User} from "./api/model.ts";

function App() {
    const [user, setUser] = useState<User | null>(null);
    useEffect(() => {
        getUser()
            .then((res) => res.json())
            .then((data) => setUser(data))
            .catch((err) => console.error('Error fetching user:', err));
    }, []);

    useEffect(() => {
        console.log(user);
    }, [user]);

    return (
        <div className={`w-full`}>
            <div className={`w-min h-screen mx-auto flex flex-col justify-center`}>
                <span>Hello</span>
                <span>{user?.id}</span>
                <span>{user?.name}</span>
                <span>{user?.email}</span>
            </div>
        </div>
    );
}

export default App;