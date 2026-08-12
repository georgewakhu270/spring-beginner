const apiUrl = '/api/authors'

async function fetchAuthors(){
    try{
        const response = await fetch(apiUrl)
        const authors = await response.json()
        const tbody = document.querySelector('#authorTableBody')
        tbody.innerHTML = '';
        authors.forEach(author => {
            const row = document.createElement('tr');
            row.innerHTML = `
                <td>${author.u_name}</td>
                <td>${author.f_name}</td>
                <td>${author.l_name}</td>
                <td><button class="delete-btn" onclick="deleteAuthor('${author.u_name}')">Delete</button></td>
            `
            tbody.appendChild(row)
        })
    } catch (error) {
        console.error('Error fetching authors: ', error)
    }
}

document.getElementById('authorForm').addEventListener('submit', async function(e) {
            e.preventDefault();

            const authorData = {
                u_name: document.getElementById('u_name').value,
                f_name: document.getElementById('f_name').value,
                l_name: document.getElementById('l_name').value,
                p_word: document.getElementById('p_word').value
            };

            try {
                const response = await fetch(apiUrl, {
                    method: 'POST',
                    headers: { 'Content-Type': 'application/json' },
                    body: JSON.stringify(authorData)
                });

                if (response.ok) {
                    document.getElementById('authorForm').reset();
                    fetchAuthors(); // Refresh table
                } else {
                    alert('Failed to save author.');
                }
            } catch (error) {
                console.error('Error saving author:', error);
            }
        });

        // Delete an author by username
        async function deleteAuthor(uName) {
            if (confirm(`Are you sure you want to delete ${uName}?`)) {
                try {
                    const response = await fetch(`${apiUrl}/${uName}`, {
                        method: 'DELETE'
                    });

                    if (response.ok) {
                        fetchAuthors(); // Refresh table
                    } else {
                        alert('Failed to delete author.');
                    }
                } catch (error) {
                    console.error('Error deleting author:', error);
                }
            }
        }

        // Initial load
        fetchAuthors();