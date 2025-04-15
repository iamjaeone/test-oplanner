import {useEffect, useState} from "react";
import { getUser } from "./api/api";
import {User} from "./api/model.ts";

function App() {
    const [user, setUser] = useState<User | null>(null);
    useEffect(() => {
            getUser()
            .then((res) => res.json())
            .then((data) => setUser(data))
            .catch((err) => console.error('Error fetching user:', err));
    }, []);

    return (
        <div className={`text-3xl bg-yellow`}>
            <span>{user?.id}</span>
            <span>{user?.name}</span>
            <span>{user?.email}</span>
        </div>
    );
}

export default App;