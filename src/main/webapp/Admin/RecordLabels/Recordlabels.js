const url = "http://localhost:8080/ICAIapp_war_exploded/api/recordLabels"

async function getRecordlabels() {
    const response = await fetch(url)
    if (!response.ok) {
        throw new Error(
            "HTTP ERROR! STATUS :${response.status}"
        );
    }
    const data = await response.json();
    data.forEach(recordlabels => {
        const recordlabelsList =
            `<li>${recordlabels.name}
            </li>`;
        document.querySelector('ol').insertAdjacentHTML('beforeend', recordlabelsList);
    })

}