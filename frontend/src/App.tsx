import {useEffect, useState} from "react";

function App() {
    const [users, setUsers] = useState([]);
    useEffect(() => {
        fetch('http://192.168.0.11:8080/api/users') // 포트 확인! docker-compose에 따라 바뀔 수 있음
            .then((res) => res.json())
            .then((data) => setUsers(data))
            .catch((err) => console.error('Error fetching users:', err));
    }, []);

    useEffect(() => {
        console.log(users);
    }, [users]);

  return (
      <div className={`text-3xl bg-yellow`}>
          <ul>
              {users.map((user) => (
                  <li key={user.id}>{user.name} ({user.email})</li>
              ))}
          </ul>
      </div>
  )
}

export default App;