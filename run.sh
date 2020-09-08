#Check if docker is installed
if [ $(which docker) ]
then
    echo "Initial docker steps"
else
    echo "You most need Docker"
    exit 0
fi

# Check if image is created
if [ -n $(docker images -q desapp-grupo-o-backend) ]
then
    echo "Using existing image"
else
    echo "Create image"
    docker build --build-arg WAR_FILE=build/libs/*.war -t springio/desapp-grupo-o-backend .
    echo "Success create image"
fi

docker run -p 8080:8080 springio/desapp-grupo-o-backend
