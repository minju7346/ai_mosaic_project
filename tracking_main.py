import face_recognition
import os
import sys
import cv2
import numpy as np
import dlib
import requests
import json

#서버상에서 
# res_get = requests.get("http://15.164.136.78:8000/S3/download")
# save_path = 'C:/Users/82105/Desktop/ai_mosaic/file'
# res_post = requests.post("http://15.164.136.78:8000")

class FaceRecognition:
    face_locations = []
    face_encodings = []
    face_names = []
    known_face_encodings = []
    known_face_names = []
    process_current_frame = True

    def __init__(self):
        self.encode_faces()

    def encode_faces(self):
        for image in os.listdir('faces'):
            face_image = face_recognition.load_image_file(f"faces/{image}")
            face_encoding = face_recognition.face_encodings(face_image)[0]

            self.known_face_encodings.append(face_encoding)
            self.known_face_names.append(image)
        print(self.known_face_names)

    def run_recognition(self):
        video_path = 'C:/Users/82105/Desktop/ai_mosaic/file/example4.mp4'
        output_path = 'C:/Users/82105/Desktop/ai_mosaic/convert/example4_convert.mp4'
        video_capture = cv2.VideoCapture(video_path)

        if not video_capture.isOpened():
            sys.exit('Video source not found...')

        # Get video properties
        fps = video_capture.get(cv2.CAP_PROP_FPS)
        width = int(video_capture.get(cv2.CAP_PROP_FRAME_WIDTH))
        height = int(video_capture.get(cv2.CAP_PROP_FRAME_HEIGHT))
        fourcc = cv2.VideoWriter_fourcc(*'mp4v')

        # Create VideoWriter object to save the processed video
        video_writer = cv2.VideoWriter(output_path, fourcc, fps, (width, height))

        face_detector = dlib.get_frontal_face_detector()
        tracker = dlib.correlation_tracker()

        while True:
            ret, frame = video_capture.read()

            if not ret:
                break

            # Only process every other frame of video to save time
            if self.process_current_frame:
                # Resize frame of video to 1/4 size for faster face recognition processing
                small_frame = cv2.resize(frame, (0, 0), fx=0.25, fy=0.25)

                # Convert the image from BGR color (which OpenCV uses) to RGB color (which face_recognition uses)
                rgb_small_frame = small_frame[:, :, ::-1]

                # Find all the faces and face encodings in the current frame of video
                face_locations = face_detector(rgb_small_frame, 1)
                face_locations = [(rect.top() * 4, rect.right() * 4, rect.bottom() * 4, rect.left() * 4)
                                  for rect in face_locations]

                self.face_locations = face_locations
                self.face_encodings = face_recognition.face_encodings(
                    rgb_small_frame, face_locations)

                self.face_names = []
                for face_encoding in self.face_encodings:
                    # See if the face is a match for the known face(s)
                    matches = face_recognition.compare_faces(
                        self.known_face_encodings, face_encoding)
                    name = "Unknown"

                    # Calculate the shortest distance to face
                    face_distances = face_recognition.face_distance(
                        self.known_face_encodings, face_encoding)

                    best_match_index = np.argmin(face_distances)
                    if matches[best_match_index]:
                        name = self.known_face_names[best_match_index]

                    self.face_names.append(name)

            self.process_current_frame = not self.process_current_frame

            # Update the face tracker
            for (top, right, bottom, left), name in zip(self.face_locations, self.face_names):
                if not hasattr(self, 'trackers'):
                    self.trackers = []
                    for (top, right, bottom, left) in self.face_locations:
                        tracker = dlib.correlation_tracker()
                        tracker.start_track(frame, dlib.rectangle(left, top, right, bottom))
                        self.trackers.append(tracker)
                else:
                    # Update each face tracker
                    for tracker in self.trackers:
                        tracker.update(frame)
                        pos = tracker.get_position()
                        left = int(pos.left())
                        top = int(pos.top())
                        right = int(pos.right())
                        bottom = int(pos.bottom())

                if name == 'Unknown':
                    # Blur the face region if it is unknown
                    face_region = frame[top:bottom, left:right]
                    blurred_face = cv2.GaussianBlur(face_region, (99, 99), 30)
                    frame[top:bottom, left:right] = blurred_face
                else:
                    # Draw bounding box and name on the frame for known faces
                    cv2.rectangle(frame, (left, top), (right, bottom), (0, 0, 255), 2)
                    cv2.rectangle(frame, (left, bottom - 35), (right, bottom), (0, 0, 255), cv2.FILLED)
                    cv2.putText(frame, name, (left + 6, bottom - 6),
                                cv2.FONT_HERSHEY_DUPLEX, 0.8, (255, 255, 255), 1)

            # Display the resulting image
            cv2.imshow('Face Recognition', frame)

            # Write the frame to the output video file
            video_writer.write(frame)

            # Hit 'q' on the keyboard to quit!
            if cv2.waitKey(1) == ord('q'):
                break

        # Release handles
        video_capture.release()
        video_writer.release()
        cv2.destroyAllWindows()


if __name__ == '__main__':
    fr = FaceRecognition()
    fr.run_recognition()
